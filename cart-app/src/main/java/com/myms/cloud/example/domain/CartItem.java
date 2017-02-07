package com.myms.cloud.example.domain;

import lombok.Data;

@Data
public class CartItem {

    /** 量 */
    private long quantity;

    private Item item;

    public boolean equalsItem(Item item) {
        return item.equals(item);
    }

    public void incrementQuantity() {
        quantity = quantity++;
    }

    public CartItem(Item item) {
        this.item = item;
        this.quantity = 1;
    }

    public String getItemId() {
        return this.item.getId();
    }

}
