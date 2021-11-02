package com.mleitejunior.springcustomeraddressmysql.service;

import com.mleitejunior.springcustomeraddressmysql.entity.Customer;
import com.mleitejunior.springcustomeraddressmysql.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import java.time.LocalDate;

public class CustomerServiceTest {

    private CustomerService service;

    @Mock
    private CustomerRepository customerRepository;

    @Captor
    private ArgumentCaptor<Customer> captor;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        service = new CustomerService(customerRepository);
    }

    @Test
    public void shouldCreateCustomer() {
        Customer customer = mockNewValidCustomer();

        service.saveCustomer(customer);

        Mockito.verify(customerRepository).save(captor.capture());

        Customer customerToCheck = captor.getValue();

        Assertions.assertNotNull(customerToCheck.getEmail());
    }

    private Customer mockNewValidCustomer(){
        Customer customer = new Customer(
                        new Integer (1),
                        "Marcelo Leite Junior",
                        "mleitejunior@gmail.com",
                        "012.345.678-9",
                        LocalDate.of(1988, 3, 4),
                        "(35) 99100-6198"
        );

        return customer;
    }

}