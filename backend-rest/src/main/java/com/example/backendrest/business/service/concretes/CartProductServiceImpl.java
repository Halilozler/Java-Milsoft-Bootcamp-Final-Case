package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.exception.NotFoundException;
import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.business.mapper.CartMapper;
import com.example.backendrest.business.mapper.CartProductMapper;
import com.example.backendrest.business.mapper.ProductMapper;
import com.example.backendrest.business.service.abstracts.CartProductService;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.business.service.abstracts.ProductService;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Product;
import com.example.backendrest.data.repository.CartProductRepository;
import com.example.backendrest.data.repository.CartRepository;
import com.example.backendrest.data.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService {
    private CartProductRepository cartProductRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository, CartRepository cartRepository, ProductRepository productRepository, EntityManager entityManager) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public BaseResponse<CartProductDto> removeCartProduct(long cartId, long productId) {
        CartProduct cartProduct = cartProductRepository.findCartProduct(cartId, productId);
        if(cartProduct == null){
            return BaseResponse.fail("Cart-Product not found", 404);
        }
        //cartProduct = cartProductRepository.findById(cartProduct.getCartProductId()).orElseThrow(() -> new NotFoundException("Cart-Product not found"));;
        cartProductRepository.delete(cartProduct);
        return BaseResponse.Success(CartProductMapper.INSTANCE.cartProductTocartProductDto(cartProduct), 200);
    }

    @Override
    public BaseResponse<CartProductDto> addCartProduct(long cartId, long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));

        CartProduct cartProduct = cartProductRepository.findCartProduct(cartId, productId);
        if(cartProduct != null){
            cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + 1);
        }else{
            cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setProduct(product);
            cartProduct.setSalesQuantity(1);
        }

        cartProduct = cartProductRepository.save(cartProduct);
        if(cartProduct.getCartProductId() == 0){
            return BaseResponse.fail("card-product could not be added", 500);
        }
        return BaseResponse.Success(CartProductMapper.INSTANCE.cartProductTocartProductDto(cartProduct), 201);
    }
}
