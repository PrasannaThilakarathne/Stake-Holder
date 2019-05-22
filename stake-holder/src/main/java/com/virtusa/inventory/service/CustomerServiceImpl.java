package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.Customer;
import com.virtusa.inventory.modal.Telephone;
import com.virtusa.inventory.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		for (Telephone telephone : customer.getTelephone()) {
			telephone.setCustomer(customer);

		}
		return customerRepository.save(customer);

	}

	public List<Customer> fetchAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> findOne(Integer id) {
		return customerRepository.findById(id);
	}

	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

}
