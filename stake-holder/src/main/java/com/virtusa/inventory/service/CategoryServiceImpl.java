package com.virtusa.inventory.service;

import java.util.List;

import com.virtusa.inventory.modal.Category;
import com.virtusa.inventory.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

	CategoryRepository categoryRepository;

	/* (non-Javadoc)
	 * @see com.virtusa.inventory.service.CategoryService#fetchAll()
	 */
	@Override
	public List<Category> fetchAll() {
		return categoryRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.virtusa.inventory.service.CategoryService#save(com.virtusa.inventory.modal.Category)
	 */
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.service.CategoryService#update(com.virtusa.inventory.modal.Category)
	 */
	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.service.CategoryService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}		
}
