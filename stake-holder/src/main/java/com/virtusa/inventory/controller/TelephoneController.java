package com.virtusa.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.Telephone;
import com.virtusa.inventory.service.TelephoneService;

@RestController
@RequestMapping("/telephones")
public class TelephoneController {

	@Autowired
	TelephoneService telephoneService;

	@RequestMapping(value = "/telephone", method = RequestMethod.GET)
	public ResponseEntity<List<Telephone>> fetchAll() {
		return ResponseEntity.ok(telephoneService.fetchAll());
	}

	@RequestMapping(value = "/telephone", method = RequestMethod.POST)
	public ResponseEntity<Telephone> save(@RequestBody Telephone telephone) {
		return ResponseEntity.ok(telephoneService.save(telephone));
	}

	@RequestMapping(value = "/telephone", method = RequestMethod.PUT)
	public ResponseEntity<Telephone> update(@RequestBody Telephone telephone) {
		return ResponseEntity.ok(telephoneService.update(telephone));
	}

	@RequestMapping(value = "/telephone", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		telephoneService.delete(id);
		return ResponseEntity.ok().build();
	}
}
