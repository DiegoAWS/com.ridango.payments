package com.ridango.payment.payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PaymentConfig {

    @Bean
    CommandLineRunner commandLineRunnerPayment(PaymentRepository paymentRepository){
        return args ->{

            paymentRepository.saveAll(
                    List.of(
                            new Payment(
                                    2L,
                                    1L,
                                    100
                            ),
                            new Payment(
                                    3L,
                                    1L,
                                    100
                            )
                    )
            );
        };
    }
}
