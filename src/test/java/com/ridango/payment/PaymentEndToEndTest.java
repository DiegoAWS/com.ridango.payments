package com.ridango.payment;

import com.ridango.payment.PaymentApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PaymentApplication.class)
@AutoConfigureMockMvc
public class PaymentEndToEndTest {
}