package com.example.backendrest.business.dto;

public class UserDto {
    private String username;
    private String email;
    private int basketItemCount;

    public UserDto() {
    }

    public UserDto(String username, String email, int basketItemCount) {
        this.username = username;
        this.email = email;
        this.basketItemCount = basketItemCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBasketItemCount() {
        return basketItemCount;
    }

    public void setBasketItemCount(int basketItemCount) {
        this.basketItemCount = basketItemCount;
    }
}
