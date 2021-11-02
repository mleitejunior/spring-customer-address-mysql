package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already taken");
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }


    public Customer updateCustomer(Customer customer, Integer id) {
        if (customerRepository.findById(id).isPresent()) {
            Customer customerRepositoryByEmail = customerRepository.findByEmail(customer.getEmail());
            if (Objects.nonNull(customerRepositoryByEmail) && customerRepositoryByEmail.getIdCustomer() != id) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
            }

            customer.setIdCustomer(id);
            return customerRepository.save(customer);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
    }

    public String deleteCustomer(int id) {
        customerRepository.deleteById(id);

        return "Customer removed : " + id;
    }

}
