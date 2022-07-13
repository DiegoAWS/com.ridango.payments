package com.ridango.payment.account;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public List<Account> getAllAccounts(){

        return List.of(
                new Account(
                        1L,
                        "Diego",
                        200
                ),
                new Account(
                        2L,
                        "Marian",
                        500
                )
        );
    }
}
