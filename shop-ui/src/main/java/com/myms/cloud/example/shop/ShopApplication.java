package com.myms.cloud.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableZuulProxy
@EnableOAuth2Sso
@EnableWebSecurity
@SpringBootApplication
public class ShopApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
        .antMatcher("/**")
        .authorizeRequests()
            .antMatchers("/login**").permitAll()
            .anyRequest().authenticated()
        .and()
            .csrf().disable();
        // @formatter:on
    }

}
