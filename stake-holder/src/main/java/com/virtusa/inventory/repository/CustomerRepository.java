package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.modal.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
