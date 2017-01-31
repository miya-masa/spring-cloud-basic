package com.myms.cloud.example.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myms.cloud.example.domain.Cart;
import com.myms.cloud.example.domain.CartRepository;
import com.myms.cloud.example.domain.Item;

@Service
public class AddCartItem {

    @Autowired
    private CartRepository cartRepository;

    public Cart addItem(Item item) {
        // TODO get user id
        Cart cart = cartRepository.loadCart("userId");
        cart.addItem(item);
        cartRepository.loadCart("userId");
        return cart;
    }
}
