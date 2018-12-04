package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.PurchaseRepository;
import com.ztbd.sportsfacility.model.Customer;
import com.ztbd.sportsfacility.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Override
    public void deletePurchase(int id) {
        purchaseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchase(int id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Purchase> getPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findAll().forEach(e -> purchases.add(e));
        return purchases;
    }

    @Override
    public List<Purchase> getCustomerPurchases(int customerId) {
        return customerService.getCustomer(customerId).getPurchases();
    }

    @Override
    public List<Purchase> getEmployeePurchases(int employeeId) {
        return employeeService.getEmployee(employeeId).getPurchases();
    }
}
