package com.virtusa.inventroy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.CustomerDetail;
import com.virtusa.inventory.repository.CustomerDetailRepository;

@Service
public class CustomerDetailServiceImpl {
	
	@Autowired
	CustomerDetailRepository customerDetailRepository;
	
	public List<CustomerDetail> fetchAll() {
		return customerDetailRepository.findAll();
	}
	
	public CustomerDetail save(CustomerDetail customer) {
		return customerDetailRepository.save(customer);
	}
	
}
