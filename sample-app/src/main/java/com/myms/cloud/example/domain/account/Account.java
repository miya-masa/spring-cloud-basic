package com.myms.cloud.example.domain.account;

import lombok.Data;

@Data
public class Account {

    private long userId;

    private String email;

    private String password;

}
