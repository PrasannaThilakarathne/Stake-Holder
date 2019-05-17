package com.virtusa.inventory.controller;

import java.util.List;
import java.util.Optional;

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

	@RequestMapping(value = "/loyaltycard/{id}", method = RequestMethod.PUT)
	public ResponseEntity<LoyaltyCardDetail> update(@PathVariable Integer id,
			@RequestBody LoyaltyCardDetail cardDetail) {
		Optional<LoyaltyCardDetail> optionalLoyaltyCard = cardDetailService.findOne(id);
		if (!optionalLoyaltyCard.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cardDetailService.save(cardDetail));
	}

}
