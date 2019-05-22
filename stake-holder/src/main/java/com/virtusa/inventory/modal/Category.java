package com.virtusa.inventory.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	Integer id;

	@NotNull
	String type;

	@NotNull
	Integer pointRange;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
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

	public Integer getPointCoverage() {
		return pointRange;
	}

	public void setPointCoverage(Integer pointCoverage) {
		this.pointRange = pointCoverage;
	}

	public List<LoyaltyCard> getLoyalitycard() {
		return loyalitycard;
	}

	public void setLoyalitycard(List<LoyaltyCard> loyalitycard) {
		this.loyalitycard = loyalitycard;
	}

}
