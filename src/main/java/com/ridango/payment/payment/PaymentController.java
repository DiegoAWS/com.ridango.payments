package com.ridango.payment.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
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
    public Payment makePayment(@RequestBody Payment payment, HttpServletResponse response){


            try {
                payment.setTimestamp();
                return paymentService.makePayment(payment);
            }
            catch (Exception e) {

                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,e.getMessage());
            }


    }
}
