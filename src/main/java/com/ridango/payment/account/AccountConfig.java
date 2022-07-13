package com.ridango.payment.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account arya= new Account( 1L, "Arya", 200 );
            Account john= new Account( 2L, "John", 200 );
            Account sansa= new Account( 3L, "Sansa", 200 );

            accountRepository.saveAll(
                    List.of(arya, john, sansa)
            );
        };
    }
}
