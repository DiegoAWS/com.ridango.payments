package com.ridango.payment.payment;

import com.ridango.payment.account.Account;
import com.ridango.payment.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, AccountRepository accountRepository) {
        this.paymentRepository = paymentRepository;
        this.accountRepository = accountRepository;
    }


    public List<Payment> getAllPayments(){

        return paymentRepository.findAll();
    }

    @Transactional
    public Payment makePayment(Payment payment){

        double amount= payment.getAmount();

        if(   BigDecimal.valueOf(amount).scale() > 2`){
            throw new IllegalStateException("Amount has more than 2 decimal places");
        }


        Account sender = accountRepository.findById(payment.getSender_account_id()).orElseThrow(
                ()->new IllegalStateException("Sender with id "+payment.getSender_account_id()+" not Found"));

       Account receiver = accountRepository.findById(payment.getReceiver_account_id()).orElseThrow(
               ()->new IllegalStateException("Receiver with id "+payment.getReceiver_account_id()+" not Found"));

       if(amount<=0){
           throw new IllegalStateException("Invalid amount "+amount);
       }

        if(sender.getBalance() < amount){
            throw new IllegalStateException("Sender has no enough balance");
        }


        sender.setBalance(sender.getBalance() - amount);

        receiver.setBalance(receiver.getBalance() + amount);

       return paymentRepository.save(payment);
    }
}
