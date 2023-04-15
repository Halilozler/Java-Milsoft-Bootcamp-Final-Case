package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.service.abstracts.AuthService;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.repository.CartProductRepository;
import com.example.backendrest.data.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    CartService cartService;
    CartProductRepository cartProductRepository;

    public AuthServiceImpl(CartService cartService, CartProductRepository cartProductRepository) {
        this.cartService = cartService;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public BaseResponse<Integer> GetBasketCount(long userId) {
        BaseResponse<Cart> cart =  cartService.getCart(userId);
        if(cart.isSuccessful() == false){
            return BaseResponse.fail("Couldn't get cart",500);
        }
        Integer cartProductSize = cartProductRepository.getCartProductSizeByCartId(cart.getData().getCartId());
        int size =  cartProductSize != null ? cartProductSize : 0;
        return BaseResponse.Success(size, 200);
    }
}
