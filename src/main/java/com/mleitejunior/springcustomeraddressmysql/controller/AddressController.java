package com.mleitejunior.springcustomeraddressmysql.controller;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/address"})
@Api(tags = "Address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "Add a Address of a Customer By ID")
    @PostMapping("/customer={customer_id}")
    public ResponseEntity<Address> addAddress(@RequestBody Address address, @PathVariable Integer customer_id) {
        return ResponseEntity.ok(addressService.saveAddressOfCustomer(address, customer_id));
    }

    @ApiOperation(value = "Find all Addresses")
    @GetMapping()
    public ResponseEntity<List<Address>> findAllAddresses() {
        return ResponseEntity.ok(addressService.getAddresses());
    }

    @ApiOperation(value = "Find a Address by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @ApiOperation(value = "Find all Addresses of a Customer ID")
    @GetMapping("/customer={customerId}")
    public ResponseEntity<List<Address>> findAddressByCustomerId(@PathVariable Integer customerId) {
        return ResponseEntity.ok(addressService.getAddressesByCustomerId(customerId));
    }

    @ApiOperation(value = "Update a Address by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Integer id) {
        return ResponseEntity.ok(addressService.updateAddress(address, id));
    }

    @ApiOperation(value = "Delete a Address by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }
}
