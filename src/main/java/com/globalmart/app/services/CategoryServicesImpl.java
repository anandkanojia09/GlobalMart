package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CategoryRepo;

import com.globalmart.app.dto.Category;

import com.globalmart.app.exception.CategoryException;

@Service
public class CategoryServicesImpl implements CategoryServices {

	@Autowired
	private CategoryRepo categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		if (category == null) {
			throw new CategoryException("Category not added please provide essiential details");
		}
		Optional<Category> category2 = categoryRepository.findById(category.getCategoryId());
		if (category2.isPresent()) {
			throw new CategoryException("Already exist");
		} else {
			return this.categoryRepository.save(category);
		}

	}

	@Override
	public Optional<Category> getCategory(Integer categoryId) throws CategoryException {

		Optional<Category> category = categoryRepository.findById(categoryId);
//		 Boolean x =categoryRepository.existsByName(category.get().getName());
//		 System.out.println(x);

		if (category.isEmpty()) {
			throw new CategoryException("category with category id " + categoryId + " does not exist");
		}
		return category;

	}

	@Override
	public List<Category> getAllCategory() throws CategoryException {

		List<Category> allCategory = new ArrayList<>();
		allCategory = categoryRepository.findAll();

		return allCategory;
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		// Integer x = category.getCategoryId();
		// Optional<Category> category1 = getCategory(x);
		if (category == null) {
			throw new CategoryException("please provide essiential details");
		}
		if (!categoryRepository.existsById(category.getCategoryId())) {
			throw new CategoryException("no category exist with category id" + category.getCategoryId());
		} else {
			categoryRepository.save(category);
			return category;
		}

	}

	@Override
	public Boolean deleteCategory(Integer categoryId) throws CategoryException {
		Boolean isDeleted = false;
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (!category.isEmpty()) {
			isDeleted = true;
			categoryRepository.deleteById(categoryId);
		} else {
			throw new CategoryException("cannot be deleted");
		}
		return isDeleted;

	}

}
