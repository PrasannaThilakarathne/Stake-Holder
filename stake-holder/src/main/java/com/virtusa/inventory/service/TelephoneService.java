package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.Telephone;

public interface TelephoneService {

	List<Telephone> fetchAll();

	Telephone save(Telephone telephone);

	Optional<Telephone> findOne(Integer id);

	void delete(Integer id);

}