package com.myms.cloud.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myms.cloud.example.domain.account.Account;
import com.myms.cloud.example.usecase.AccountUsecase;

@RestController
public class AccountController {

    /** ロガー */
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountUsecase accountUsecase;

    @GetMapping("account")
    public Account account() {

        return new Account("userId", "email", "password");
    }

}
