package com.example.pointsawarded.service;

import com.example.pointsawarded.model.Transaction;
import com.example.pointsawarded.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    //Get Total Rewards in three months
    public double getTotalRewards(Long customerId) {
        List<Transaction> allTransactions = getTransactions();
        int total = 0;
        for(Transaction transaction : allTransactions) {
            if (transaction.getCustomer_id() == customerId) {
                total += helper(transaction.getAmount());
            }
        }
        return total;
    }

    //Get Total Rewards in a given month
    public ArrayList getTotalMonthlyRewards(Long customerId) {
        List<Transaction> allTransactions = getTransactions();
        ArrayList total = new ArrayList(3);
        for (int i = 1; i <= 3; i++) {
            int cur = 0;
            for(Transaction transaction : allTransactions) {
            if (transaction.getCustomer_id() == customerId && inMonth(transaction.getDate(), i)) {
                cur += helper(transaction.getAmount());
            }

        }
            total.add(cur);
        }
        return total;
    }

    //return the points awarded given the amount of purchase
    public static int helper(double amount) {
        int bar = 50;
        int reward = 0;
        while (bar < amount) {
            reward += amount - bar;
            bar += 50;
        }
        return reward;
    }

    //return true if transaction was occurred in month i
    public static boolean inMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int cur= cal.get(Calendar.MONTH) + 1;
        return cur == month;
    }
}
