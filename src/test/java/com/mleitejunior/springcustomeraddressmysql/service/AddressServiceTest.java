package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Address;
import com.mleitejunior.springcustomeraddressmysql.repository.AddressRepository;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Captor
    private ArgumentCaptor<Address> captor;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        addressService = new AddressService(addressRepository, customerRepository);
    }

    @Test
    public void shouldCreateAddress() {
        Address address = mockNewValidAddress();

        addressService.saveAddressOfCustomer(address, 1);

        Mockito.verify(addressService).saveAddressOfCustomer(captor.capture(), 1);

        Address addressToCheck = captor.getValue();

        Assert.assertNotNull(addressToCheck.getZipcode());
        Assert.assertNotNull(addressToCheck.getStreet());
        Assert.assertNotNull(addressToCheck.getNumber());
        Assert.assertNotNull(addressToCheck.getCity());
        Assert.assertNotNull(addressToCheck.getState());
        Assert.assertNotNull(addressToCheck.getCountry());
        Assert.assertNotNull(addressToCheck.getCustomer());
    }


    private Address mockNewValidAddress(){
        return new Address(
                1,
                "37754-106",
                "Rua Paulo Henrique de Oliveira",
                "no. 70",
                "apto. 302",
                "",
                "Pouso Alegre",
                "Minas Gerais",
                "Brazil",
                null
        );
    }
}