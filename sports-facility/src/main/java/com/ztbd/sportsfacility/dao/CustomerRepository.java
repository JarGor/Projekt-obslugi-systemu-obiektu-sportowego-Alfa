package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {}