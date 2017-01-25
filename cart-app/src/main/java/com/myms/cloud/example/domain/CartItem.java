package com.myms.cloud.example.domain;

import lombok.Data;

@Data
public class CartItem {

    /** 量 */
    private long quantity;

    private Item item;

}
