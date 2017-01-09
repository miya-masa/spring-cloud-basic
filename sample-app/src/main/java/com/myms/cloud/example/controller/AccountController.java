package com.myms.cloud.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    /** ロガー */
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Value("${info.foo}")
    private String hello;

    @Value("${hello.sample}")
    private String sample;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        log.info(sample);
        return hello;
    }
}
