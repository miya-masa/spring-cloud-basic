package com.myms.cloud.example.domain.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myms.cloud.example.domain.account.Account;
import com.myms.cloud.example.domain.account.AccountRepository;

@Service
@Transactional
public class AccountService implements UserDetailsManager {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username);
        User user = new User(username, account.getPassword(), Collections.emptyList());
        return user;
    }

    @Override
    public void createUser(UserDetails user) {
        Account newAccount = Account.create(user.getUsername(), user.getPassword());
        accountRepository.save(newAccount);
    }

    @Override
    public void updateUser(UserDetails user) {
        Account account = accountRepository.findByEmail(user.getUsername());
        account.setEmail(user.getUsername());
        account.setPassword(user.getPassword());
        accountRepository.save(account);
    }

    @Override
    public void deleteUser(String username) {
        Account deleteTarget = accountRepository.findByEmail(username);
        accountRepository.delete(deleteTarget);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

        Authentication currentAuthentication = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .orElseThrow(RuntimeException::new);

        String username = currentAuthentication.getName();

        Authentication newAuthenticated =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));

        Account targetUser = accountRepository.findByEmail(username);
        targetUser.setPassword(newPassword);
        accountRepository.save(targetUser);

        SecurityContextHolder.getContext().setAuthentication(newAuthenticated);
    }

    @Override
    public boolean userExists(String username) {
        ExampleMatcher emailEqualsIgnoreCase =
                ExampleMatcher.matching().withIgnoreCase("email").withNullHandler(NullHandler.IGNORE);
        return accountRepository.exists(Example.of(new Account(null, username, null), emailEqualsIgnoreCase));
    }

}
