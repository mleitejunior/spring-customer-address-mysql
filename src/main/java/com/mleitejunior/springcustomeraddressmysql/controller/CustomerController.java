package com.mleitejunior.springcustomeraddressmysql.controller;

import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/customer"})
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping()
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.saveCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteCustomer(id));
    }
}
