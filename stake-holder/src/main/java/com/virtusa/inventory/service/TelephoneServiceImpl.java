package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.Telephone;
import com.virtusa.inventory.repository.TelephoneRepository;

@Service
public class TelephoneServiceImpl implements TelephoneService {

	@Autowired
	private TelephoneRepository telephoneRepository;

	@Override
	public List<Telephone> fetchAll() {
		return telephoneRepository.findAll();
	}

	@Override
	public Telephone save(Telephone telephone) {
		return telephoneRepository.save(telephone);
	}

	@Override
	public void delete(Integer id) {
		telephoneRepository.deleteById(id);
	}

	@Override
	public Optional<Telephone> findOne(Integer id) {
		return telephoneRepository.findById(id);
	}
}
