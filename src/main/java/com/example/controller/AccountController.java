package com.example.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.math.BigDecimal;

@Controller("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
    public HttpResponse<Account> updateAccountBalance(@PathVariable Long accountId, @Body BigDecimal newBalance) {
        return HttpResponse.ok(accountService.updateAccountBalance(accountId, newBalance));
    }

    @Get("/{accountId}/validate")
    public HttpResponse<Boolean> validateAccount(@PathVariable Long accountId) {
        return HttpResponse.ok(accountService.validateAccount(accountId));
    }
}
