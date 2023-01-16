package com.example.pointsawarded.service;

import com.example.pointsawarded.model.Transaction;
import com.example.pointsawarded.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
        TransactionRepository transactionRepository;

    //CREATE
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    //READ
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    //DELETE
    public void deleteTransaction(Long trans_id) {
        transactionRepository.deleteById(trans_id);
    }

    //UPDATE
    public Transaction updateTransaction(Long trans_id, Transaction transaction) {
        Transaction target = transactionRepository.findById(trans_id).get();
        target.setDate(transaction.getDate());
        target.setAmount(transaction.getAmount());
        target.setCustomer_id(transaction.getCustomer_id());

        return transactionRepository.save(target);
    }
}
