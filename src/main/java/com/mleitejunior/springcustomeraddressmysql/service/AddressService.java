package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.repository.AddressRepository;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    public Address saveAddressOfCustomer(Address address, Integer customerId) {
        if (Objects.isNull(customerId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address needs a Customer");
        }

        Optional<Customer> customerById = customerRepository.findById(customerId);

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

    public List<Address> getAddressesByCustomerId(Integer customerId) {
        Optional<Customer> customerById = customerRepository.findById(customerId);

        if (!customerById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");

        }

        return addressRepository.findByCustomer(customerById.get());
    }


    public Address updateAddress(Address address, Integer addressId) {
        Optional<Address> addressRepositoryById = addressRepository.findById(addressId);
        if (addressRepositoryById.isPresent()) {
            address.setIdAddress(addressId);
            address.setCustomer(addressRepositoryById.get().getCustomer());
            return addressRepository.save(address);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
    }

    public String deleteAddress(Integer id) {
        Optional<Address> addressRepositoryById = addressRepository.findById(id);
        if (addressRepositoryById.isPresent()) {
            addressRepository.deleteById(id);

            return "Address removed : " + id;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
    }

}
