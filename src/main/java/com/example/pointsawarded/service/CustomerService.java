package com.example.pointsawarded.service;

import com.example.pointsawarded.model.Customer;
import com.example.pointsawarded.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //CREATE
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //READ
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    //DELETE
    public void deleteCustomer(Long customer_id) {
        customerRepository.deleteById(customer_id);
    }

    //UPDATE
    public Customer updateCustomer(Long customer_id, Customer customer) {
        Customer target = customerRepository.findById(customer_id).get();
        target.setName(customer.getName());

        return customerRepository.save(target);
    }
}
