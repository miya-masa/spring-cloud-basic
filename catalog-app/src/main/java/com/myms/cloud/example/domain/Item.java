package com.myms.cloud.example.domain;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private String id;

    public String getId() {
        return this.id;
    }

}
