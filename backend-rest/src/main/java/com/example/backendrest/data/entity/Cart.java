package com.example.backendrest.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Users users;
    private String cardNumber;
    @Enumerated(EnumType.STRING)
    private CartStatus cartStatus;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Cart() {}

    public Cart(String cardNumber, CartStatus cartStatus) {
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
    }

    public Cart(String cardNumber, CartStatus cartStatus, Date createdDate) {
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        cartId = cartId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
