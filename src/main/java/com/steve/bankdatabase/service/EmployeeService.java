package com.steve.bankdatabase.service;

import com.steve.bankdatabase.controller.EmployeeController;
import com.steve.bankdatabase.entity.Employee;
import com.steve.bankdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee, Long id){
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAccount_type(employee.getAccount_type());
        existingEmployee.setAccount_number(employee.getAccount_number());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    public String deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return "Employee with id number: " + id + " has been deleted.";

    }
}