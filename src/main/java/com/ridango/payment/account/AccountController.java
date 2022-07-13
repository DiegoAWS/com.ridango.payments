package com.ridango.payment.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path = "account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService _accountService) {
        this.accountService = _accountService;
    }

    @GetMapping
    public  List<Account> getAccounts(){
//        return accountService.getAllAccounts();
        return accountService.getAllAccounts();
    }
}
