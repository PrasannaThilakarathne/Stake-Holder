package com.virtusa.inventory.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.modal.Category;
import com.virtusa.inventory.service.CategoryService;;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> fetchAll() {
		return ResponseEntity.ok(categoryService.fetchAll());
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<Category> save(@Valid @RequestBody Category category) {

		if (category.getType() != null || category.getPointRange() != null) {
			
			Category newCategory = new Category();
			newCategory.setId(category.getId());
			newCategory.setPointRange(category.getPointRange());
			newCategory.setType(category.getType().toLowerCase());
			
			return ResponseEntity.ok(categoryService.save(newCategory));
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@Valid @RequestBody Category category) {
		if (category.getType() != null || category.getPointRange() != null) {
			
			Category newCategory = new Category();
			newCategory.setId(category.getId());
			newCategory.setPointRange(category.getPointRange());
			newCategory.setType(category.getType().toLowerCase());
			
			return ResponseEntity.ok(categoryService.update(newCategory));
		}
		else {
			return ResponseEntity.badRequest().build(); 
		}
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		
		if(categoryService.findById(id)!=null) {
			categoryService.delete(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build(); 
		}
		
	}
}
