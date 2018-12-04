package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Employee;

import java.util.List;

public interface EmployeeService {
    void deleteEmployee(int id);
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getEmployees();
    Employee updateEmployee(int id, Employee employee);
}
