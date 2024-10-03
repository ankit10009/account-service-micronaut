package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@Controller("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @Post
    public HttpResponse<Account> createAccount(@Body @Valid Account account) {
        return HttpResponse.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }
    

    @Get("/{accountId}")
    public HttpResponse<Account> getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Get("/{accountId}/balance")
    public HttpResponse<BigDecimal> getAccountBalance(@PathVariable Long accountId) {
        return HttpResponse.ok(accountService.getAccountBalance(accountId));
    }

    @Put("/{accountId}/balance")
    public HttpResponse<Account> updateAccountBalance(@PathVariable Long accountId, @QueryValue BigDecimal newBalance) {
        return HttpResponse.ok(accountService.updateAccountBalance(accountId, newBalance));
    }

    @Get("/{accountId}/validate")
    public HttpResponse<Boolean> validateAccount(@PathVariable Long accountId) {
        return HttpResponse.ok(accountService.validateAccount(accountId));
    }
}
