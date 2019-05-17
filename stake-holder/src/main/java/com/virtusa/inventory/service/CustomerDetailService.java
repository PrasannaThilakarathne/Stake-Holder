package com.virtusa.inventory.service;

import java.util.List;

import com.virtusa.inventory.modal.CustomerDetail;

public interface CustomerDetailService {

	List<CustomerDetail> fetchAll();

	CustomerDetail save(CustomerDetail customer);

	CustomerDetail update(CustomerDetail customer);

	void delete(Integer id);

}