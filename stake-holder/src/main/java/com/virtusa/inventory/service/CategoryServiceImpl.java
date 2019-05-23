package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.modal.Category;
import com.virtusa.inventory.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> fetchAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

}
