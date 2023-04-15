package com.example.backendrest.presentation.rest;

import com.example.backendrest.base.Util.JwtUtils;
import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.*;
import com.example.backendrest.business.service.abstracts.CartProductService;
import com.example.backendrest.business.service.abstracts.CartService;
import com.example.backendrest.business.service.concretes.CartServiceImpl;
import com.example.backendrest.business.service.concretes.CartProductServiceImpl;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartProductService cartproductService;
    private CartService cartService;
    private JwtUtils jwtUtils;

    public CartController(CartProductService cartproductService, CartService cartService, JwtUtils jwtUtils) {
        this.cartproductService = cartproductService;
        this.cartService = cartService;
        this.jwtUtils = jwtUtils;
    }

    //cart oluşturur.
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/get")
    public BaseResponse<Cart> getCartById(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }

        return cartService.getCart(userId);
    }

    //siperişi verdiğimiz cartları getirir.
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/get/completed")
    public BaseResponse<List<CartProductCompleteDto>> getCompleteCartProduct(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        //token içinden bir veri almak için:
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartproductService.getCompleteProductById(userId);
    }

    //cartı complete çekmek isterse:
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/set/completed")
    public BaseResponse<Boolean> setCompleted(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartService.setCartCompleted(userId);
    }
    //**
    //sepeteki(new olan) ürünleri getirir.
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/get/new")
    public BaseResponse<List<CartProductGetDto>> getNewCartProduct(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartproductService.getNewProductById(userId);
    }
    //**
    //carta ürün ekler.
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add/{productId}/{salesQuantity}")
    public BaseResponse<CartProductDto> addCart(@PathVariable("productId") long productId, @PathVariable("salesQuantity") int salesQuantity, @RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        if(salesQuantity < 1){
            salesQuantity = 1;
        }
        return cartproductService.addCartProduct(productId, userId, salesQuantity);
    }
    //**
    //cartan new ürün silmek isterse.
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/remove/{productId}")
    public BaseResponse<CartProductDto> removeCartAndProduct(@PathVariable("productId") long productId, @RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartproductService.removeCartProduct(productId, userId);
    }
    //Bütün cartı silme
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/remove/all")
    public BaseResponse<Boolean> removeAllCartProduct(@RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartproductService.removeAllCartProduct(userId);
    }
    //salesquantity 1 azaltma
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/remove/quantity/{productId}")
    public BaseResponse<Boolean> removeQuantityCartProduct(@PathVariable("productId") long productId, @RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        return cartproductService.removeCartQuantityProduct(productId, userId);
    }
    //**
    //cart bilgileri değiştiricek
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/checkout")
    public BaseResponse<CartDto> updateCard(@RequestBody CartUpdateDto cartUpdateDto, @RequestHeader(value = "Authorization", required = true) String bearerToken){
        String token = bearerToken.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(token);
        if(userId == 0){
            BaseResponse.fail("user not found", 500);
        }
        if(cartUpdateDto.getCardNumber().length() != 16){
            return BaseResponse.fail("card number must be 16 digits", 400);
        }
        return cartService.updateCart(cartUpdateDto, userId);
    }
}
