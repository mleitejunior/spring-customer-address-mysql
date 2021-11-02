package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        if (repository.findByEmail(customer.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already taken");
        }

        return repository.save(customer);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }


    public Customer updateCustomer(Customer customer) {
        if (repository.findById(customer.getIdCustomer()).isPresent()) {
            return repository.save(customer);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
    }

    public String deleteCustomer(int id) {
        repository.deleteById(id);

        return "Customer removed : " + id;
    }

}
