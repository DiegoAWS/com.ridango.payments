package com.ridango.payment.payment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Payment
{
    @Id
    @SequenceGenerator(
            name="payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private long id;

    private long sender_account_id;


    private long receiver_account_id;

    private Integer amount;

    private LocalDate timestamp;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", sender_account_id=" + sender_account_id +
                ", receiver_account_id=" + receiver_account_id +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSender_account_id() {
        return sender_account_id;
    }

    public void setSender_account_id(long sender_account_id) {
        this.sender_account_id = sender_account_id;
    }

    public long getReceiver_account_id() {
        return receiver_account_id;
    }

    public void setReceiver_account_id(long receiver_account_id) {
        this.receiver_account_id = receiver_account_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = LocalDate.now();
    }

    public Payment() {
    }

    public Payment(long sender_account_id, long receiver_account_id, Integer amount) {
        this.sender_account_id = sender_account_id;
        this.receiver_account_id = receiver_account_id;
        this.amount = amount;
        this.timestamp = LocalDate.now();
    }

    public Payment(long id, long sender_account_id, long receiver_account_id, Integer amount) {
        this.id = id;
        this.sender_account_id = sender_account_id;
        this.receiver_account_id = receiver_account_id;
        this.amount = amount;
        this.timestamp = LocalDate.now();
    }
}
