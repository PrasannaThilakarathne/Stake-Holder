package com.virtusa.inventory.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.modal.Category;

public interface CategoryService {

	List<Category> fetchAll();

	Category save(Category category);

	Optional<Category> findOne(Integer id);

	void delete(Integer id);

}