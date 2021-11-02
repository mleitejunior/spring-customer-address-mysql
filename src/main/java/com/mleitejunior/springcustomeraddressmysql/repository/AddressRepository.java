package com.mleitejunior.springcustomeraddressmysql.repository;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCustomer(Customer customer);
}
