package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.CustomerRepository;
import com.ztbd.sportsfacility.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(e -> customers.add(e));
        return customers;
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Customer retCustomer = customerRepository.findById(id).orElse(null);
        if(customer.getFirstName() != null)
            retCustomer.setFirstName(customer.getFirstName());
        if(customer.getLastName() != null)
            retCustomer.setLastName(customer.getLastName());
        if(customer.getPhoneNumber() != 0)
            retCustomer.setPhoneNumber(customer.getPhoneNumber());
        if(customer.getAddress() != null)
            retCustomer.setAddress(customer.getAddress());
        if(customer.getEnterLogs() != null)
            retCustomer.setEnterLogs(customer.getEnterLogs());
        if(customer.getExitLogs() != null)
            retCustomer.setExitLogs(customer.getExitLogs());
        if(customer.getPurchases() != null)
            retCustomer.setPurchases(customer.getPurchases());
        if(customer.getEmail() != null)
            retCustomer.setEmail(customer.getEmail());
        saveCustomer(retCustomer);
        return retCustomer;
    }
}
