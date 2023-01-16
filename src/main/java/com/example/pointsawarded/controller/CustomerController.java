package com.example.pointsawarded.controller;

import com.example.pointsawarded.model.Customer;
import com.example.pointsawarded.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value="/customers", method=RequestMethod.GET)
    public List<Customer> readCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value="/customers/{customerId}", method=RequestMethod.PUT)
    public Customer updateCustomers(@PathVariable(value="customerId") Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @RequestMapping(value="/customers/{customerId}", method=RequestMethod.DELETE)
    public void deleteCustomers(@PathVariable(value="customerId") Long id) {
        customerService.deleteCustomer(id);
    }
}
