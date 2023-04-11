package com.example.backendrest.business.service.concretes;

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
import com.example.backendrest.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public BaseResponse<CartDto> getCart(long cartId) {
        Optional<Cart> optional = cartRepository.findById(cartId);
        if(!optional.isPresent()){
            Cart newCart = new Cart(RandomCustomerName(), RandomCartNumbers(), Cart.CartStatus.NEW);
            BaseResponse<Cart> add = addCart(CartMapper.INSTANCE.cartToCartDto(newCart));
            if(add.isSuccessful() == false){
                return BaseResponse.fail("card could not be added",500);
            }
            return BaseResponse.Success(CartMapper.INSTANCE.cartToCartDto(add.getData()), 200);
        }
        return BaseResponse.Success(CartMapper.INSTANCE.cartToCartDto(optional.get()), 200);
    }

    @Override
    public BaseResponse<Cart> addCart(CartDto cartDto) {
        Cart savedCart = cartRepository.save(CartMapper.INSTANCE.cartDtotoCart(cartDto));
        if(savedCart.getCartId() == 0){
            return BaseResponse.fail("card could not be added",500);
        }
        return BaseResponse.Success(savedCart, 201);
    }

    @Override
    public BaseResponse<CartDto> updateCart(CartUpdateDto cartUpdateDto) {
        Optional<Cart> optional = cartRepository.findById(cartUpdateDto.getCartId());
        if(!optional.isPresent()){
            return BaseResponse.fail("card not found",404);
        }
        Cart cart = optional.get();
        cart.setCartStatus(cartUpdateDto.getCartStatus());
        cart.setCardNumber(cartUpdateDto.getCardNumber());
        cart.setCustomerName(cartUpdateDto.getCustomerName());
        Cart savedCart = cartRepository.save(cart);
        if(savedCart.getCartId() == 0){
            return BaseResponse.fail("card could not be update",500);
        }
        return BaseResponse.Success(CartMapper.INSTANCE.cartToCartDto(savedCart), 200);
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
