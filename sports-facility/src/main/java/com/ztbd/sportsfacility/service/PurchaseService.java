package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Purchase;

import java.util.List;

public interface PurchaseService {
    void deletePurchase(int id);
    void savePurchase(Purchase purchase);
    Purchase getPurchase(int id);
    List<Purchase> getPurchases();
    List<Purchase> getCustomerPurchases(int customerId);
    List<Purchase> getEmployeePurchases(int employeeId);
}
