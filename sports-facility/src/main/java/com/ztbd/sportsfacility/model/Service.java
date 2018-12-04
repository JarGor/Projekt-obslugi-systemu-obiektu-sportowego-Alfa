package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH },
                fetch = FetchType.LAZY)
    @JoinTable(name = "purchases_services",
               joinColumns = @JoinColumn(name = "service_id"),
               inverseJoinColumns = @JoinColumn(name = "purchase_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Purchase> purchases;

    public Service() {}

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}