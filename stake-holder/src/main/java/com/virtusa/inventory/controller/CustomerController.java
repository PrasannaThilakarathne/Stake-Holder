package com.virtusa.inventory.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.Customer;
import com.virtusa.inventory.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
//		if(customer==null) {
//			System.out.println("customer is nulll");
//		}
		return ResponseEntity.ok(customerService.save(customer));
	}

	@RequestMapping(value = "/fetchdetails", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> fetchAll() {
		return ResponseEntity.ok(customerService.fetchAll());
	}
	

	@RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> update(@Valid @PathVariable Integer id, @RequestBody Customer customer) {

		Optional<Customer> optionalCustomer = customerService.findOne(id);
		if (!optionalCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Customer customerupdated = optionalCustomer.get();
		customerupdated.setfName(customer.getfName());
		customerupdated.setlName(customer.getlName());
		customerupdated.setAddress(customer.getAddress());
		customerupdated.setCard(customer.getCard());
		customerupdated.setDateOfBirth(customer.getDateOfBirth());
		customerupdated.setGender(customer.getGender());
		customerupdated.setEmail(customer.getEmail());
		customerupdated.setSalutation(customer.getSalutation());
		customerupdated.setOccupation(customer.getOccupation());

		return ResponseEntity.ok(customerService.save(customerupdated));

	}
	@RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@Valid @PathVariable Integer id) {

		Optional<Customer> optionalCustomer = customerService.findOne(id);

		if (!optionalCustomer.isPresent()) {
			return HttpStatus.NOT_FOUND;
		}
		customerService.deleteCustomer(id);
		return HttpStatus.OK;
	}

}
