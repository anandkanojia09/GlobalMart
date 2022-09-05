package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.CategoryException;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.CategoryServices;

@RestController
public class CategoryController {

	
	
	@Autowired
	CategoryServices categoryServices;

	@PostMapping("category")
    public Category addCategory( @Valid @RequestBody Category category) throws MethodArgumentNotValidException , CategoryException {

		return categoryServices.addCategory(category);
	}

	
	@GetMapping("category/{id}")
	public Optional<Category> getCategoryById(@PathVariable Integer id) throws CategoryException {

		return categoryServices.getCategory(id);
	}

	@GetMapping("category/all")
	public List<Category> getAllCategories() throws CategoryException {

		return categoryServices.getAllCategory();
	}

	
	@PatchMapping("category")
	public Category updateCategory(@RequestBody Category category) throws CategoryException {

		return categoryServices.updateCategory(category);
	}
	

	
	@DeleteMapping("category/{id}")
	public Boolean deleteCategory(@PathVariable Integer id) throws CategoryException {

		 return categoryServices.deleteCategory(id);
	
	}
	
	@GetMapping("allproducts")
	public List<Product> getAllProducts(Integer CategoryId) throws ProductException, CategoryException{
		return categoryServices.getAllProducts(CategoryId);
	}

	
}
