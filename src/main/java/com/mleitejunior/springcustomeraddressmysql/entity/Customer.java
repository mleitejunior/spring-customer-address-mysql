package com.mleitejunior.springcustomeraddressmysql.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    private Integer idCustomer;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String document;
    private LocalDate birthdate;
    private String phone;

    public Customer(Integer idCustomer, String name, String email, String document, LocalDate birthdate, String phone) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.document = document;
        this.birthdate = birthdate;
        this.phone = phone;
    }

    public Customer() {

    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
