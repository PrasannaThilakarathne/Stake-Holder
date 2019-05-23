package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.Address;

public interface AddressService {

	List<Address> fetchAll();

	Address save(Address address);

	Optional<Address> findOne(Integer id);

	void delete(Integer id);

}