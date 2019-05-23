package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.modal.LoyaltyCard;

public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCard, Integer> {

}
