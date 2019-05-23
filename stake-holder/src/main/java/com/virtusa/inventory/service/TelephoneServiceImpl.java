package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.Telephone;
import com.virtusa.inventory.repository.TelephoneRepository;

public class TelephoneServiceImpl implements TelephoneService {

	TelephoneRepository telephoneRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.virtusa.inventory.service.TelephoneService#fetchAll()
	 */
	@Override
	public List<Telephone> fetchAll() {
		return telephoneRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.virtusa.inventory.service.TelephoneService#save(com.virtusa.inventory
	 * .modal.Telephone)
	 */
	@Override
	public Telephone save(Telephone telephone) {
		return telephoneRepository.save(telephone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.virtusa.inventory.service.TelephoneService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		telephoneRepository.deleteById(id);
	}

	@Override
	public Optional<Telephone> findOne(Integer id) {
		return telephoneRepository.findById(id);
	}
}
