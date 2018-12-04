package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String firstName;

    private String lastName;

    private String peselNumber;

    private int phoneNumber;

    private String address;

    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH },
               fetch = FetchType.LAZY,
               mappedBy = "employee")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Purchase> purchases;

    public Employee() {}

    public Employee(String firstName, String lastName, String peselNumber, int phoneNumber, String address, String email, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = peselNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.user = user;
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

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}