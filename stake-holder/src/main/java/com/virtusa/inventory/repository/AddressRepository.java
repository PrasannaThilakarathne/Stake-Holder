package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
