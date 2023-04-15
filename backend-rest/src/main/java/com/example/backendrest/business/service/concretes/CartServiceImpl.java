package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.exception.NotFoundException;
import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.business.mapper.CartMapper;
import com.example.backendrest.business.mapper.CartProductMapper;
import com.example.backendrest.business.mapper.CartUpdateMapper;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Users;
import com.example.backendrest.data.repository.CartProductRepository;
import com.example.backendrest.data.repository.CartRepository;
import com.example.backendrest.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private CartProductRepository cartProductRepository;
    private UserRepository userRepository;

    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse<Cart> getCart(long userId) {
        Cart cart = cartRepository.getCartByUserId(userId, CartStatus.NEW);
        //Optional<Cart> optional = cartRepository.findById(cartId);
        if(cart == null){
            Optional<Users> userOptional = userRepository.findById(userId);
            if(!userOptional.isPresent()){
                return BaseResponse.fail("user not found",404);
            }
            Cart newCart = new Cart(RandomCartNumbers(), CartStatus.NEW);
            newCart.setUsers(userOptional.get());
            BaseResponse<Cart> add = addCart(CartMapper.INSTANCE.cartToCartDto(newCart), newCart.getUsers());
            if(add.isSuccessful() == false){
                return BaseResponse.fail("card could not be added",500);
            }
            return BaseResponse.Success(add.getData(), 200);
        }
        return BaseResponse.Success(cart, 200);
    }

    @Override
    public BaseResponse<Cart> addCart(CartDto cartDto, Users users) {
        Cart savedCart = CartMapper.INSTANCE.cartDtotoCart(cartDto);
        //savedCart.setUsers(userRepository.findById(savedCart.getCartId()).orElseThrow(() -> new NotFoundException("user not found")));
        savedCart.setUsers(users);
        cartRepository.save(savedCart);
        if(savedCart.getCartId() == 0){
            return BaseResponse.fail("card could not be added",500);
        }
        return BaseResponse.Success(savedCart, 201);
    }

    @Override
    public BaseResponse<CartDto> updateCart(CartUpdateDto cartUpdateDto, long userId) {
        BaseResponse<Cart> cartDto = getCart(userId);
        if(cartDto.isSuccessful() == false){
            return BaseResponse.fail("An error occurred while receiving the cart",500);
        }
        Cart cart = cartRepository.findById(cartDto.getData().getCartId()).get();
        cart.setCardNumber(cartUpdateDto.getCardNumber());

        List<CartProduct> cartProduct = cartProductRepository.getCartProduct(cart.getCartId(), CartStatus.NEW);
        if(cartProduct.size() >= 1){
            cart.setCartStatus(CartStatus.COMPLETED);
            cart.setCreatedDate(Calendar.getInstance().getTime());
        }

        Cart savedCart = cartRepository.save(cart);
        if(savedCart.getCartId() == 0){
            return BaseResponse.fail("cart could not be update",500);
        }
        return BaseResponse.Success(CartMapper.INSTANCE.cartToCartDto(savedCart), 200);
    }

    //cartı complete çeker ve tarih yazar.
    @Override
    public BaseResponse<Boolean> setCartCompleted(long userId) {
        //Cart cart2 = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("cart not found"));
        Cart cart = cartRepository.getCartByUserId(userId, CartStatus.NEW);
        if(cart == null){
            return BaseResponse.fail("You don't have a cart",404);
        }
        /*
        if(cart.getUsers().getUsersId() != userId){
            return BaseResponse.fail("unauthorized access",401);
        }
        */
        //cartın içinde product varmı bakar yoksa izin vermez.
        List<CartProduct> cartProduct = cartProductRepository.getCartProduct(cart.getCartId(), CartStatus.NEW);
        if(cartProduct.size() < 1){
            return BaseResponse.fail("There are no products in the cart", 500);
        }
        cart.setCartStatus(CartStatus.COMPLETED);
        cart.setCreatedDate(Calendar.getInstance().getTime());
        Cart savedCart = cartRepository.save(cart);
        if(savedCart.getCartId() == 0){
            return BaseResponse.fail("cart could not be update",500);
        }
        return BaseResponse.Success(true, 200);
    }

    private String RandomCartNumbers(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int num = rand.nextInt(10);
            sb.append(num);
        }

        return sb.toString();
    }

    private String RandomCustomerName(){
        Random rand = new Random();
        String[] names = {"Emma Smith", "Liam Johnson", "Olivia Brown", "Noah Taylor", "Ava Wilson", "William Anderson", "Sophia Thomas", "James Jackson", "Isabella White", "Oliver Harris", "Charlotte Martin", "Benjamin Thompson", "Amelia Garcia", "Lucas Martinez", "Mia Davis"};
        return names[rand.nextInt(16)];
    }
}
