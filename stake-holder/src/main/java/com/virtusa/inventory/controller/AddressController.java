package com.virtusa.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.Address;
import com.virtusa.inventory.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> fetchAll() {
		return ResponseEntity.ok(addressService.fetchAll());
	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public ResponseEntity<Address> save(@RequestBody Address address) {
		return ResponseEntity.ok(addressService.save(address));
	}

	@RequestMapping(value = "/address", method = RequestMethod.PUT)
	public ResponseEntity<Address> update(@RequestBody Address address) {
		return ResponseEntity.ok(addressService.update(address));
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		addressService.delete(id);
		return ResponseEntity.ok().build();
	}
}
