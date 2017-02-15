package com.myms.cloud.example.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.annotation.Id;

public class Cart implements Serializable {

    private static final long serialVersionUID = 8329559983943337176L;

    @Id
    private String id;

    // TODO to first collection
    private Map<String, CartItem> cartItems = new ConcurrentHashMap<>();

    public int getNumberOfItems() {
        return cartItems.size();
    }

    public void addItem(Item item) {
        CartItem cartItem = cartItems.getOrDefault(item.getId(), new CartItem(item));
        cartItem.incrementQuantity();
        cartItems.put(cartItem.getItemId(), cartItem);
    }

    public Optional<Item> removeItemById(String itemId) {
        return Optional.ofNullable(cartItems.remove(itemId)).map(CartItem::getItem);
    }

    public void incrementQuantityByItemId(String itemId) {
        CartItem cartItem = cartItems.get(itemId);
        cartItem.incrementQuantity();
    }
    //
    // public void setQuantityByItemId(String itemId, int quantity) {
    // CartItem cartItem = (CartItem) itemMap.get(itemId);
    // cartItem.setQuantity(quantity);
    // }
    //
    // public BigDecimal getSubTotal() {
    // BigDecimal subTotal = new BigDecimal("0");
    // Iterator<CartItem> items = getAllCartItems();
    // while (items.hasNext()) {
    // CartItem cartItem = (CartItem) items.next();
    // Item item = cartItem.getItem();
    // BigDecimal listPrice = item.getListPrice();
    // BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
    // subTotal = subTotal.add(listPrice.multiply(quantity));
    // }
    // return subTotal;
    // }

}
