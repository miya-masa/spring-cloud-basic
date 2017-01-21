package com.myms.cloud.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableOAuth2Sso
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
