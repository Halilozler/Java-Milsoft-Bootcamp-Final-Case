package com.example.backendrest.presentation.rest;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.CartProductGetDto;
import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.business.service.abstracts.CartProductService;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.business.service.concretes.CartServiceImpl;
import com.example.backendrest.business.service.concretes.CartProductServiceImpl;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartProductService cartproductService;
    private CartService cartService;
    public CartController(CartProductService cartproductService, CartService cartService) {
        this.cartproductService = cartproductService;
        this.cartService = cartService;
    }

    @GetMapping("/get/{cartId}")
    public BaseResponse<CartDto> getCartById(@PathVariable("cartId") long cartId){
        return cartService.getCart(cartId);
    }

    @GetMapping("/get/complete/{cartId}")
    public BaseResponse<List<CartProductGetDto>> getCompleteCartProduct(@PathVariable("cartId") long cartId){
        return cartproductService.getCompleteProductById(cartId);
    }

    @GetMapping("/get/new/{cartId}")
    public BaseResponse<List<CartProductGetDto>> getNewCartProduct(@PathVariable("cartId") long cartId){
        return cartproductService.getNewProductById(cartId);
    }

    @PostMapping("/add/{cartId}/{productId}")
    public BaseResponse<CartProductDto> addCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        return cartproductService.addCartProduct(cartId, productId);
    }

    @DeleteMapping("/remove/{cartId}/{productId}")
    public BaseResponse<CartProductDto> removeCartAndProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        return cartproductService.removeCartProduct(cartId, productId);
    }

    @PutMapping("/checkout")
    public BaseResponse<CartDto> updateCard(@RequestBody CartUpdateDto cartUpdateDto){
        if(cartUpdateDto.getCardNumber().length() != 16){
            return BaseResponse.fail("card number must be 16 digits", 400);
        }
        cartUpdateDto.setCartStatus(Cart.CartStatus.COMPLETED);
        return cartService.updateCart(cartUpdateDto);
    }
}
