package com.virtusa.inventory.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@NotNull
	@Column(unique = true)
	String type;

	@NotNull
	Integer pointRange;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	List<LoyaltyCard> loyalitycard;

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

	public Integer getPointRange() {
		return pointRange;
	}

	public void setPointRange(Integer pointRange) {
		this.pointRange = pointRange;
	}

	public List<LoyaltyCard> getLoyalitycard() {
		return loyalitycard;
	}

	public void setLoyalitycard(List<LoyaltyCard> loyalitycard) {
		this.loyalitycard = loyalitycard;
	}

}
