package com.ridango.payment.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunnerAccount(AccountRepository accountRepository){
        return args -> {
            Account arya    = new Account(  "Arya", 100 );
            Account john    = new Account(  "John", 100 );
            Account sansa   = new Account( "Sansa", 100 );
            Account eddard = new Account( "Eddard", 100 );

            accountRepository.saveAll(
                    List.of(arya, john, sansa, eddard)
            );
        };
    }
}
