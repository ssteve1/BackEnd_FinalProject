package com.steve.bankdatabase.controller;
import com.steve.bankdatabase.entity.Customer;
import com.steve.bankdatabase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


   @Autowired
    private CustomerService customerService;


    @PostMapping("/add")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/AllCustomers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/findCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}
