package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Customer;
import com.ztbd.sportsfacility.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getEmployee(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
