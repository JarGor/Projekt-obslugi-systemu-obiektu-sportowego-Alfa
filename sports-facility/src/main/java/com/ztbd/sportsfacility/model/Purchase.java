package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ztbd.sportsfacility.utility.LocalDateDeserializer;
import com.ztbd.sportsfacility.utility.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate purchaseDate;

    @ManyToOne(/*cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH },*/
               fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;

    @ManyToOne(/*cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH },*/
               fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;

    @ManyToMany(/*cascade = { CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH },*/
                fetch = FetchType.EAGER)
    @JoinTable(name = "purchases_services",
               joinColumns = @JoinColumn(name = "purchase_id"),
               inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;

    @Transient
    private String purchaseEmployee;

    @Transient
    private String purchaseCustomer;

    public Purchase() {}

    public Purchase(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void addService(Service service) {
        if(services == null) {
            services = new ArrayList<>();
        }

        services.add(service);
    }

    public String getPurchaseEmployee() {
        String pEmployee = "";
        if(employee != null) {
            pEmployee = employee.getLastName() + " " + employee.getFirstName();
        }
        return pEmployee;
    }

    public void setPurchaseEmployee(String purchaseEmployee) {
        this.purchaseEmployee = purchaseEmployee;
    }

    public String getPurchaseCustomer() {
        String pCustomer = "";
        if(customer != null) {
            pCustomer = customer.getLastName() + " " + customer.getFirstName();
        }
        return pCustomer;
    }

    public void setPurchaseCustomer(String purchaseCustomer) {
        this.purchaseCustomer = purchaseCustomer;
    }
}