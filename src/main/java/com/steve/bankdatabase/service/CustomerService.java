package com.steve.bankdatabase.service;

import com.steve.bankdatabase.entity.Customer;
import com.steve.bankdatabase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer customer, Long id){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setDob(customer.getDob());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAccount_type(customer.getAccount_type());
        existingCustomer.setAccount_number(customer.getAccount_number());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    public String deleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "Customer with id number: " + id + " has been deleted.";

    }



}
