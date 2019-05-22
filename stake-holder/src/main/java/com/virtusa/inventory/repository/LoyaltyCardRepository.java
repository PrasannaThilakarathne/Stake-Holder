package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.inventory.modal.LoyaltyCard;

@Repository
public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCard, Integer>{

}
