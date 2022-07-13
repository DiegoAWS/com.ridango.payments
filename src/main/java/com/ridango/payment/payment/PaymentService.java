package com.ridango.payment.payment;

import com.ridango.payment.account.Account;
import com.ridango.payment.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Payment makePayment(Payment payment){

        int amount= payment.getAmount();

        Optional<Account> sender = accountRepository.findById(payment.getSender_account_id());
        Optional<Account> receiver = accountRepository.findById(payment.getReceiver_account_id());

        if(!sender.isPresent()){
            throw new RuntimeException("Sender with id "+payment.getSender_account_id()+" not Found");
        }
        if(!receiver.isPresent()){
            throw new RuntimeException("Receiver with id "+payment.getReceiver_account_id()+" not Found");
        }

        if(sender.get().getBalance() < amount){
            throw new RuntimeException("Sender has no enough balance");
        }


        Account senderInstance = sender.get();

        senderInstance.setBalance(senderInstance.getBalance() - amount);

        accountRepository.save(senderInstance);

        Account receiverInstance = sender.get();

        receiverInstance.setBalance(receiverInstance.getBalance() + amount);

        accountRepository.save(receiverInstance);


       return paymentRepository.save(payment);
    }
}
