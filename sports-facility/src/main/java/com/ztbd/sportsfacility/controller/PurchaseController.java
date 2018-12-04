package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Purchase;
import com.ztbd.sportsfacility.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchases")
    public List<Purchase> getPurchases() {
        return purchaseService.getPurchases();
    }

    @GetMapping("/purchases/customer/{customerId}")
    public List<Purchase> getCustomerPurchases(@PathVariable int customerId) {
        return purchaseService.getCustomerPurchases(customerId);
    }

    @GetMapping("/purchases/employee/{employeeId}")
    public List<Purchase> getEmployeePurchases(@PathVariable int employeeId) {
        return purchaseService.getEmployeePurchases(employeeId);
    }

    @GetMapping("/purchases/{purchaseId}")
    public Purchase getPurchase(@PathVariable int purchaseId) {
        return purchaseService.getPurchase(purchaseId);
    }

    @PostMapping("/purchases")
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        purchaseService.savePurchase(purchase);
        return purchase;
    }
}
