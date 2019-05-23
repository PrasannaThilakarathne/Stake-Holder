package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.Address;
import com.virtusa.inventory.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	AddressRepository addressRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.virtusa.inventory.service.AddressService#fetchAll()
	 */
	@Override
	public List<Address> fetchAll() {
		return addressRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.virtusa.inventory.service.AddressService#save(com.virtusa.inventory.
	 * modal.Address)
	 */
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.virtusa.inventory.service.AddressService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Optional<Address> findOne(Integer id) {
		return addressRepository.findById(id);
	}
}
