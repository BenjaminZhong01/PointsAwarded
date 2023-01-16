package com.example.pointsawarded.controller;

import com.example.pointsawarded.model.Transaction;
import com.example.pointsawarded.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value="/transactions", method= RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @RequestMapping(value="/transactions", method=RequestMethod.GET)
    public List<Transaction> readTransactions() {
        return transactionService.getTransactions();
    }

    @RequestMapping(value="/transactions/{transactionId}", method=RequestMethod.PUT)
    public Transaction updateTransactions(@PathVariable(value="transactionId") Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @RequestMapping(value="/transactions/{transactionId}", method=RequestMethod.DELETE)
    public void deleteTransactions(@PathVariable(value="transactionId") Long id) {
        transactionService.deleteTransaction(id);
    }

    @RequestMapping(value="/transactions/rewards/total/{customerId}", method=RequestMethod.GET)
    public double getTotalRewards(@PathVariable(value = "customerId") Long id) {
        return transactionService.getTotalRewards(id);
    }

    @RequestMapping(value="/transactions/rewards/monthly/{customerId}", method=RequestMethod.GET)
    public ArrayList getMonthlyRewards(@PathVariable(value = "customerId") Long id) {
        return transactionService.getTotalMonthlyRewards(id);
    }
}
