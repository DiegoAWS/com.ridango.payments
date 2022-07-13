package com.ridango.payment.account;

public class Account {
    private Long id;
    private String name;
    private Integer balance;

    public Account() {
    }

    public Account(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account(Long id, String name, Integer balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
