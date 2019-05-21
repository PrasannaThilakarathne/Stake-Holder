package com.virtusa.inventory.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	private	String address;
	private String telephone;
	
	@OneToOne(cascade = CascadeType.ALL)
	LoyaltyCardDetail cardDetail;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public LoyaltyCardDetail getCardDetail() {
		return cardDetail;
	}
	public void setCardDetail(LoyaltyCardDetail cardDetail) {
		this.cardDetail = cardDetail;
	}
	
	
	
	

}
