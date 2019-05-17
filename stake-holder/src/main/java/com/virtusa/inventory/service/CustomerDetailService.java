package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.CustomerDetail;

public interface CustomerDetailService {

	List<CustomerDetail> fetchAll();

	CustomerDetail save(CustomerDetail customer);

	Optional<CustomerDetail> findOne(Integer id);

	void delete(Integer id);

}