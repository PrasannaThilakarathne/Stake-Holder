package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.modal.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
