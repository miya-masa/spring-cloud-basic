package com.myms.cloud.example.domain;

public interface CartRepository {
    void save(Cart cart);

    Cart loadCart(String string);
}
