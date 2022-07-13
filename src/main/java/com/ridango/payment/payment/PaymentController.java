package com.ridango.payment.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getPayments(){
        return paymentService.getAllPayments();
    }

    @PostMapping
    public String makePayment(@RequestBody Payment payment, HttpServletResponse response) throws IOException {

            try {
                payment.setTimestamp();
                return paymentService.makePayment(payment).toString();
            }
            catch (Exception e) {

                response.sendError(400 ,e.getMessage());
                return e.getMessage();
            }


    }
}
