package com.virtusa.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.CustomerDetail;
import com.virtusa.inventroy.service.CustomerDetailService;

@RestController
@RequestMapping(value = "/customerdetail")
public class CustomerDetailController {

	@Autowired
	CustomerDetailService customerDetailService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDetail>> fetchAll() {
		return ResponseEntity.ok(customerDetailService.fetchAll());
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<CustomerDetail> save(@RequestBody CustomerDetail customer) {
		return ResponseEntity.ok(customerDetailService.save(customer));
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public ResponseEntity<CustomerDetail> update(@RequestBody CustomerDetail customer ) {
		return ResponseEntity.ok(customerDetailService.update(customer));
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		customerDetailService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
