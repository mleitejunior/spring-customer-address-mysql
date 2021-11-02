package com.mleitejunior.springcustomeraddressmysql.controller;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/address"})
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/customer={customer_id}")
    public ResponseEntity<Address> addAddress(@RequestBody Address address, @PathVariable Integer customer_id) {
        return ResponseEntity.ok(addressService.saveAddressOfCustomer(address, customer_id));
    }

    @GetMapping()
    public ResponseEntity<List<Address>> findAllAddresses() {
        return ResponseEntity.ok(addressService.getAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping("/customer={customer_id}")
    public ResponseEntity<List<Address>> findAddressByCustomerId(@PathVariable Integer customer_id) {
        return ResponseEntity.ok(addressService.getAddressesByCustomerId(customer_id));
    }

    @PutMapping()
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }
}
