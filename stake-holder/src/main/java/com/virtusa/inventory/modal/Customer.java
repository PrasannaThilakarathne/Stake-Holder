package com.virtusa.inventory.modal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@NotNull
	private Integer id;

	@NotNull
	private String gender;

	private String occupation;

	@NotNull
	private String salutation;

	@Size(min = 8, max = 8)
	private Date dateOfBirth;

	@NotNull
	@Size(min = 3, message = "First Name must not be empty")
	private String fName;

	@NotNull
	@Size(min = 3, message = "Last Name must not be empty")
	private String lName;

	@NotNull
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	@OneToOne(cascade = CascadeType.ALL)
	LoyaltyCard card;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Telephone> telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LoyaltyCard getCard() {
		return card;
	}

	public void setCard(LoyaltyCard card) {
		this.card = card;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

}
