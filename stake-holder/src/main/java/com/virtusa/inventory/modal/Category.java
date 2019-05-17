package com.virtusa.inventory.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	Integer id;
	String type;
	Integer points;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<LoyaltyCardDetail> cardDetails;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public List<LoyaltyCardDetail> getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(List<LoyaltyCardDetail> cardDetails) {
		this.cardDetails = cardDetails;
	}
	
	
	
	
}
