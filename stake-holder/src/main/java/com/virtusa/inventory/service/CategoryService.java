package com.virtusa.inventory.service;

import java.util.List;

import com.virtusa.inventory.modal.Category;

public interface CategoryService {

	List<Category> fetchAll();

	Category save(Category category);

	Category update(Category category);

	void delete(Integer id);

}