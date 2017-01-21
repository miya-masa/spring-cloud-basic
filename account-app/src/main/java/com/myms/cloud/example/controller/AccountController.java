package com.myms.cloud.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myms.cloud.example.application.AccountUsecase;

@RestController
public class AccountController {

    /** ロガー */
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountUsecase accountUsecase;

}
