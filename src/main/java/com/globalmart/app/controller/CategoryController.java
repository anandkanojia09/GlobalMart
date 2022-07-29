package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.CategoryRepo;
import com.globalmart.app.dto.Category;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepo categoryRepo;

	@PostMapping("category")
	public Category addCategory(@RequestBody Category category) {
		return categoryRepo.save(category);
	}

	@GetMapping("category/{id}")
	public Optional<Category> getCategory(@PathVariable Integer categoryId) {
		return categoryRepo.findById(categoryId);
	}

	@GetMapping("category/all")
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@PostMapping("category/update")
	public Category updateCategory(@RequestBody Category category) {
		return categoryRepo.save(category);
	}

	@DeleteMapping("category/delete/{id}")
	public void deleteCategory(@PathVariable Integer categoryId) {
		categoryRepo.deleteById(categoryId);
	}

	@DeleteMapping("category/delete")
	public void deleteCategory(@PathVariable Category category) {
		categoryRepo.delete(category);
	}
}
