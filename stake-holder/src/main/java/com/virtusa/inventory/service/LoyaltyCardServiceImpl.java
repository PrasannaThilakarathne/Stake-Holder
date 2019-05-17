package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtusa.inventory.modal.LoyaltyCardDetail;
import com.virtusa.inventory.repository.LoyaltyCardDetailsRepository;

public class LoyaltyCardServiceImpl implements LoyaltyCardDetailService {
	
	@Autowired
	LoyaltyCardDetailsRepository loyaltyCard;

	@Override
	public LoyaltyCardDetail save(LoyaltyCardDetail cardDetail) {
		
		return loyaltyCard.save(cardDetail);
	}

	@Override
	public List<LoyaltyCardDetail> fetchAll() {
		
		return loyaltyCard.findAll();
	}

	@Override
	public Optional<LoyaltyCardDetail> findOne(Integer id) {
		return loyaltyCard.findById(id);
	}

}
