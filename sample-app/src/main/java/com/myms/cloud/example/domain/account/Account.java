package com.myms.cloud.example.domain.account;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Account {

    @Id
    private Long userId;

    private String email;

    private String password;

}
