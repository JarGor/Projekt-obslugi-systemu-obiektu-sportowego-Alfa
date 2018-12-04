package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String address;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "primaryKey.customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<EnterLog> enterLogs;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               mappedBy = "primaryKey.customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ExitLog> exitLogs;

    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH },
               fetch = FetchType.LAZY,
               mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Purchase> purchases;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LocalDateTime> customerEnterLogs;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LocalDateTime> customerExitLogs;

    public Customer() {}

    public Customer(String firstName, String lastName, int phoneNumber, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EnterLog> getEnterLogs() {
        return enterLogs;
    }

    public void setEnterLogs(List<EnterLog> enterLogs) {
        this.enterLogs = enterLogs;
    }

    public void addEnterLog(EnterLog enterLog) {
        if(enterLogs == null) {
            enterLogs = new ArrayList<>();
        }

        enterLogs.add(enterLog);
    }

    public List<ExitLog> getExitLogs() {
        return exitLogs;
    }

    public void setExitLogs(List<ExitLog> exitLogs) {
        this.exitLogs = exitLogs;
    }

    public void addExitLog(ExitLog exitLog) {
        if(exitLogs == null) {
            exitLogs = new ArrayList<>();
        }

        exitLogs.add(exitLog);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase purchase) {
        if(purchases == null) {
            purchases = new ArrayList<>();
        }

        purchases.add(purchase);
    }

    public List<LocalDateTime> getCustomerEnterLogs() {
        if(enterLogs != null) {
            customerEnterLogs = new ArrayList<>();

            for(EnterLog enterLog: enterLogs) {
                customerEnterLogs.add(enterLog.getEnterTime());
            }
        }
        return customerEnterLogs;
    }

    public void setCustomerEnterLogs(List<LocalDateTime> customerEnterLogs) {
        this.customerEnterLogs = customerEnterLogs;
    }

    public List<LocalDateTime> getCustomerExitLogs() {
        if(exitLogs != null) {
            customerExitLogs = new ArrayList<>();

            for(ExitLog exitLog: exitLogs) {
                customerExitLogs.add(exitLog.getExitTime());
            }
        }
        return customerExitLogs;
    }

    public void setCustomerExitLogs(List<LocalDateTime> customerExitLogs) {
        this.customerExitLogs = customerExitLogs;
    }
}