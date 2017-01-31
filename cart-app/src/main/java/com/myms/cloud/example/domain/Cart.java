package com.myms.cloud.example.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;

public class Cart implements Serializable {

    private static final long serialVersionUID = 8329559983943337176L;

    @Id
    private String id;

    // TODO to first collection
    private List<CartItem> cartItems;

    public int getNumberOfItems() {
        return cartItems.size();
    }

    public void addItem(Item item) {
        Optional<CartItem> cartItemOpt = cartItems.stream().filter(e -> e.equalsItem(item)).findAny();
        if (cartItemOpt.isPresent()) {
            cartItemOpt.get().incrementQuantity();
            return;
        }
        CartItem cartItem = new CartItem(item);
        cartItems.add(cartItem);
    }

    // public Item removeItemById(String itemId) {
    // CartItem cartItem = (CartItem) itemMap.remove(itemId);
    // if (cartItem == null) {
    // return null;
    // } else {
    // itemList.remove(cartItem);
    // return cartItem.getItem();
    // }
    // }
    //
    // public void incrementQuantityByItemId(String itemId) {
    // CartItem cartItem = (CartItem) itemMap.get(itemId);
    // cartItem.incrementQuantity();
    // }
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
