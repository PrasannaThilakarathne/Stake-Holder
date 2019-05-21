package com.virtusa.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.exception.ObjectNotFoundException;
import com.virtusa.inventory.modal.CustomerDetail;
import com.virtusa.inventory.modal.LoyaltyCardDetail;
import com.virtusa.inventory.service.CustomerDetailService;

@RestController
@RequestMapping("/customer")
public class CustomerDetailController {

	@Autowired
	CustomerDetailService customerDetailService;

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public ResponseEntity<CustomerDetail> save(@RequestBody CustomerDetail customerDetail) {
		return ResponseEntity.ok(customerDetailService.save(customerDetail));
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDetail>> fetchAll() {
		return ResponseEntity.ok(customerDetailService.fetchAll());
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDetail> fetchOne(@PathVariable Integer id) {
		Optional<CustomerDetail> optionalCustomer = customerDetailService.findOne(id);
		if (!optionalCustomer.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}

		return ResponseEntity.ok(optionalCustomer.get());
	}

	@RequestMapping(value = "/details/{id}/loyalty", method = RequestMethod.GET)
	public ResponseEntity<LoyaltyCardDetail> fetchCustomerLoyalty(@PathVariable Integer id) {
		Optional<CustomerDetail> optionalCustomer = customerDetailService.findOne(id);
		if (!optionalCustomer.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}

		return ResponseEntity.ok(optionalCustomer.get().getCardDetail());
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CustomerDetail> update(@PathVariable Integer id, @RequestBody CustomerDetail customerDetail) {

		Optional<CustomerDetail> optionalCustomer = customerDetailService.findOne(id);

		if (!optionalCustomer.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}

		CustomerDetail customerUpdated = optionalCustomer.get();
		customerUpdated.setName(customerDetail.getName());
		customerUpdated.setAddress(customerDetail.getAddress());
		customerUpdated.setCardDetail(customerDetail.getCardDetail());
		customerUpdated.setTelephone(customerDetail.getTelephone());

		return ResponseEntity.ok(customerDetailService.save(customerUpdated));
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
	public HttpStatus update(@PathVariable Integer id) {

		Optional<CustomerDetail> optionalCustomer = customerDetailService.findOne(id);

		if (!optionalCustomer.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}
		customerDetailService.delete(id);
		return HttpStatus.OK;
	}

}
