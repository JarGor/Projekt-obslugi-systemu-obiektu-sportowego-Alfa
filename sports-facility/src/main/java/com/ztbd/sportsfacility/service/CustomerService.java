package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Customer;

import java.util.List;

public interface CustomerService {
    void deleteCustomer(int id);
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getCustomers();
    Customer updateCustomer(int id, Customer customer);
}
