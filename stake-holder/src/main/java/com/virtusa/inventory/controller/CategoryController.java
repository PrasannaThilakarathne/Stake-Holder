package com.virtusa.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.exception.ObjectNotFoundException;
import com.virtusa.inventory.modal.Category;
import com.virtusa.inventory.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> fetchAll() {
		return ResponseEntity.ok(categoryService.fetchAll());
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> fetchOne(@PathVariable Integer id) {
		Optional<Category> optionalCategory = categoryService.findOne(id);
		if (!optionalCategory.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}
		return ResponseEntity.ok(optionalCategory.get());
	}

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public ResponseEntity<Category> save(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.save(category));
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@PathVariable Integer id,@RequestBody Category category) {
		Optional<Category> optionalCategory = categoryService.findOne(id);
		if (!optionalCategory.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}
		
		Category categoryUpdated = optionalCategory.get();
		categoryUpdated.setType(category.getType());
		categoryUpdated.setPoints(category.getPoints());
		categoryUpdated.setCardDetails(category.getCardDetails());
		
		return ResponseEntity.ok(categoryService.save(categoryUpdated));
	}
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable Integer id) {
		Optional<Category> optionalCategory = categoryService.findOne(id);
		if (!optionalCategory.isPresent()) {
			throw new ObjectNotFoundException("id - " + id);
		}
		
		categoryService.delete(id);
		return HttpStatus.OK;
	}
}
