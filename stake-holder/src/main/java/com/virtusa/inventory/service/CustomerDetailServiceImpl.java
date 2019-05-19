package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.CustomerDetail;
import com.virtusa.inventory.repository.CustomerDetailRepository;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {
	
	@Autowired
	CustomerDetailRepository customerDetailRepository;
	
	@Override
	public List<CustomerDetail> fetchAll(){
		return  customerDetailRepository.findAll();
	}
	
	@Override
	public CustomerDetail save(CustomerDetail customer) {
		return customerDetailRepository.save(customer);
	}
	
	@Override
	public void delete(Integer id) {
		customerDetailRepository.deleteById(id);
	}

	@Override
	public Optional<CustomerDetail> findOne(Integer id) {
		return customerDetailRepository.findById(id);
	}
	
	
}