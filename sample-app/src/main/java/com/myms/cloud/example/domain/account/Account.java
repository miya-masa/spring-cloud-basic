package com.myms.cloud.example.domain.account;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    @Id
    private String userId;

    private String email;

    private String password;

    public static Account create(String email, String password) {
        return new Account(UUID.randomUUID().toString(), email, password);
    }

}
