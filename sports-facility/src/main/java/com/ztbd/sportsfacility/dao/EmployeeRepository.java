package com.ztbd.sportsfacility.dao;

import com.ztbd.sportsfacility.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}