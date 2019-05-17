package com.virtusa.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.LoyaltyCardDetail;
import com.virtusa.inventory.service.LoyaltyCardDetailService;

@RestController
@RequestMapping("/loyaltycarddetail")

public class LoyaltyCardDetailController {

	@Autowired
	LoyaltyCardDetailService cardDetailService;

	@RequestMapping(value = "/loyaltycard", method = RequestMethod.GET)
	public ResponseEntity<List<LoyaltyCardDetail>> fetchAll() {
		return ResponseEntity.ok(cardDetailService.fetchAll());
	}

	@RequestMapping(value = "/loyaltycard", method = RequestMethod.POST)
	public ResponseEntity<LoyaltyCardDetail> save(@RequestBody LoyaltyCardDetail cardDetail) {
		return ResponseEntity.ok(cardDetailService.save(cardDetail));
	}

	@RequestMapping(value = "/loyaltycard", method = RequestMethod.PUT)
	public ResponseEntity<LoyaltyCardDetail> update(@RequestBody LoyaltyCardDetail cardDetail) {
		return ResponseEntity.ok(cardDetailService.update(cardDetail));
	}


}
