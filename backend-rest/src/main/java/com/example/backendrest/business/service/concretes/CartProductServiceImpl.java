package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.exception.NotFoundException;
import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.*;
import com.example.backendrest.business.mapper.CartMapper;
import com.example.backendrest.business.mapper.CartProductGetMapper;
import com.example.backendrest.business.mapper.CartProductMapper;
import com.example.backendrest.business.mapper.ProductMapper;
import com.example.backendrest.business.service.abstracts.CartProductService;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.business.service.abstracts.ProductService;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Product;
import com.example.backendrest.data.repository.CartProductRepository;
import com.example.backendrest.data.repository.CartRepository;
import com.example.backendrest.data.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {
    private CartProductRepository cartProductRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private CartService cartService;

    public CartProductServiceImpl(CartProductRepository cartProductRepository, CartRepository cartRepository, ProductRepository productRepository, EntityManager entityManager, CartService cartService) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartService = cartService;
    }

    @Override
    @Transactional
    public BaseResponse<CartProductDto> removeCartProduct(long productId, long userId) {
        BaseResponse<Cart> cartDto = cartService.getCart(userId);
        if(cartDto.isSuccessful() == false){
            return BaseResponse.fail("An error occurred while receiving the cart",500);
        }
        CartProduct cartProduct = cartProductRepository.findCartProduct(cartDto.getData().getCartId(), productId);
        if(cartProduct == null){
            return BaseResponse.fail("Cart-Product not found", 404);
        }
        if(cartProduct.getCart().getUsers().getUsersId() != userId){
            return BaseResponse.fail("unauthorized access",401);
        }
        //cartProduct = cartProductRepository.findById(cartProduct.getCartProductId()).orElseThrow(() -> new NotFoundException("Cart-Product not found"));;
        cartProductRepository.writeDelete(cartProduct.getCartProductId());
        return BaseResponse.Success(CartProductMapper.INSTANCE.cartProductTocartProductDto(cartProduct), 200);
    }

    @Override
    public BaseResponse<CartProductDto> addCartProduct(long productId, long userId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
        //Optional<Cart> cart = cartRepository.findById(cartId);
        BaseResponse<Cart> cartDto = cartService.getCart(userId);
        if(cartDto.isSuccessful() == false){
            return BaseResponse.fail("An error occurred while receiving the cart",500);
        }

        CartProduct cartProduct = cartProductRepository.findCartProduct(cartDto.getData().getCartId(), productId);
        if(cartProduct != null){
            cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + 1);
        }else{
            cartProduct = new CartProduct();
            cartProduct.setCart(cartDto.getData());
            cartProduct.setProduct(product);
            cartProduct.setSalesQuantity(1);
        }

        cartProduct = cartProductRepository.save(cartProduct);
        if(cartProduct.getCartProductId() == 0){
            return BaseResponse.fail("card-product could not be added", 500);
        }
        return BaseResponse.Success(CartProductMapper.INSTANCE.cartProductTocartProductDto(cartProduct), 201);
    }

    @Override
    public BaseResponse<List<CartProductCompleteDto>> getCompleteProductById(long userId) {

        List<Cart> cartList = cartRepository.getListCartByUserId(userId, CartStatus.COMPLETED);
        if(cartList.isEmpty()){
            BaseResponse.fail("complete cart not found", 404);
        }
        List<CartProductCompleteDto> result = new ArrayList<>();
        for(Cart cart : cartList){
            result.add(getCartProductCompleteDto(cart.getCartId()));

        }
        return BaseResponse.Success(result, 200);
    }

    private CartProductCompleteDto getCartProductCompleteDto(long cartId){
        CartProductCompleteDto response = new CartProductCompleteDto();
        List<CartProduct> cartProductList = cartProductRepository.getCartProductByCartId(cartId);
        if(!cartProductList.isEmpty()){
            //response.setCartDto(CartMapper.INSTANCE.cartToCartDto(cartProductList.get(0).getCart()));
            response.setCardNumber(cartProductList.get(0).getCart().getCardNumber());
            response.setCreatedDate(cartProductList.get(0).getCart().getCreatedDate());
            List<CartProductGetDto> cartProductGetDtoList = new ArrayList<>();
            for(CartProduct cartProduct : cartProductList){
                cartProductGetDtoList.add(new CartProductGetDto(cartProduct.getCartProductId(), new ProductDto(cartProduct.getProduct().getProductId(), cartProduct.getProduct().getProductName(), cartProduct.getProduct().getSalesPrice()), cartProduct.getSalesQuantity()));
            }
            response.setCartProductGetDtoList(cartProductGetDtoList);
        }
        return response;
    }

    @Override
    public BaseResponse<List<CartProductGetDto>> getNewProductById(long userId) {
        //her userın bir tane new cartı olucak diyelim.
        Cart cart = cartRepository.getCartByUserId(userId, CartStatus.NEW);
        if(cart == null){
            //cart yoksa oluşturur.
            BaseResponse<Cart> cartDto = cartService.getCart(userId);
            cart.setCartId(cartDto.getData().getCartId());
        }
        List<CartProduct> cartProductList = cartProductRepository.getCartProduct(cart.getCartId(), CartStatus.NEW);
        List<CartProductGetDto> result = new ArrayList<>();
        for(CartProduct cartProduct : cartProductList){
            result.add(CartProductGetMapper.INSTANCE.cartProductToCartProductGetDto(cartProduct));
        }
        return BaseResponse.Success(result, 200);
    }
}
