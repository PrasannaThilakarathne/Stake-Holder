package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.LoyaltyCardDetail;

public interface LoyaltyCardDetailService {
	
	public LoyaltyCardDetail save(LoyaltyCardDetail cardDetail);
	
	public List<LoyaltyCardDetail> fetchAll();
	
	public Optional<LoyaltyCardDetail> findOne(Integer id);
	
	public void delete(Integer id);

}
