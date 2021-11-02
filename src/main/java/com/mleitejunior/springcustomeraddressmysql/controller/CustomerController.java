package com.mleitejunior.springcustomeraddressmysql.controller;

import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/customer"})
@Api(tags = "Customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @ApiOperation(value = "Find all Customers")
    @GetMapping()
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @ApiOperation(value = "Add a customer")
    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.saveCustomer(customer));
    }

    @ApiOperation(value = "Find customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @ApiOperation(value = "Update Customer by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        return ResponseEntity.ok(service.updateCustomer(customer, id));
    }

    @ApiOperation(value = "Delete Customer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteCustomer(id));
    }
}
