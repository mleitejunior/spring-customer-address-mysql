package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceTest {

    @Autowired
    private AddressService service;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<Address> captor;

    public AddressServiceTest() {
    }

    @Test
    public void shouldCreateAddress() {
//        Address address = mockNewValidAddress();
//
//        service.saveAddress(address);
//
//        Mockito.verify(service).saveAddress(captor.capture());
//
//        Address addressToCheck = captor.getValue();
//
//        Assert.assertNotNull(addressToCheck.getZipcode());
//        Assert.assertNotNull(addressToCheck.getStreet());
//        Assert.assertNotNull(addressToCheck.getNumber());
//        Assert.assertNotNull(addressToCheck.getCity());
//        Assert.assertNotNull(addressToCheck.getState());
//        Assert.assertNotNull(addressToCheck.getCountry());
//        Assert.assertNotNull(addressToCheck.getCustomer());
    }


    private Address mockNewValidAddress(){
        return new Address(
                new Integer(1),
                "37754-106",
                "Rua Paulo Henrique de Oliveira",
                "no. 70",
                "apto. 302",
                "",
                "Pouso Alegre",
                "Minas Gerais",
                "Brazil",
                new Customer(
                        new Integer (1),
                        null,
                        null,
                        null,
                        null,
                        null
                )
        );
    }
}