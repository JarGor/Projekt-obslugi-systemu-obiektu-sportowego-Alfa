package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.EmployeeRepository;
import com.ztbd.sportsfacility.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        if(employee.getUser() != null)
            employee.getUser().setPassword(passwordEncoder.encode(employee.getUser().getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(e -> employees.add(e));
        return employees;
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee retEmployee = employeeRepository.findById(id).orElse(null);
        if(employee.getUser() != null)
            retEmployee.setUser(employee.getUser());
        if(employee.getFirstName() != null)
            retEmployee.setFirstName(employee.getFirstName());
        if(employee.getLastName() != null)
            retEmployee.setLastName(employee.getLastName());
        if(employee.getPeselNumber() != null)
            retEmployee.setPeselNumber(employee.getPeselNumber());
        if(employee.getPhoneNumber() != 0)
            retEmployee.setPhoneNumber(employee.getPhoneNumber());
        if(employee.getAddress() != null)
            retEmployee.setAddress(employee.getAddress());
        if(employee.getPurchases() != null)
            retEmployee.setPurchases(employee.getPurchases());
        if(employee.getEmail() != null)
            retEmployee.setEmail(employee.getEmail());
        saveEmployee(retEmployee);
        return retEmployee;
    }
}
