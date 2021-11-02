package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.repository.AddressRepository;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Address saveAddressOfCustomer(Address address, Integer customer_id) {
        if (Objects.isNull(customer_id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address needs a Customer");
        }

        Optional<Customer> customerById = customerRepository.findById(customer_id);

        if (!customerById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        address.setCustomer(customerById.get());
        return addressRepository.save(address);
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> getAddressesByCustomerId(Integer customer_id) {
        Optional<Customer> customerById = customerRepository.findById(customer_id);

        if (!customerById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");

        }

        return addressRepository.findByCustomer(customerById.get());
    }


    public Address updateAddress(Address address) {
        Optional<Address> addressRepositoryById = addressRepository.findById(address.getIdAddress());
        if (addressRepositoryById.isPresent()) {
            address.setCustomer(addressRepositoryById.get().getCustomer());
            return addressRepository.save(address);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
    }

    public String deleteAddress(int id) {
        addressRepository.deleteById(id);

        return "Address removed : " + id;
    }

}
