package com.example.pointsawarded.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "transaction_date")
    private Date date;

    @Column(name = "transaction_amount")
    private double amount;

    @Column(name = "transaction_customer")
    private Long customer_id;

    public Transaction(){}
    public Transaction(Date date, double amount, Long customer_id) {
        this.date = date;
        this.amount = amount;
        this.customer_id = customer_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
