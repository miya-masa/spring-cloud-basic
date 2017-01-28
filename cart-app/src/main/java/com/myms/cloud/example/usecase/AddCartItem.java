package com.myms.cloud.example.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myms.cloud.example.domain.Cart;
import com.myms.cloud.example.domain.CartItem;
import com.myms.cloud.example.domain.CartRepository;

@Service
public class AddCartItem {

    @Autowired
    private CartRepository cartRepository;

    public Cart addItem(CartItem item) {
        // cartRepository.load();
        return new Cart();
    }
}
