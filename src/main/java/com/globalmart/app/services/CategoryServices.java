package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;



import com.globalmart.app.dto.Category;
import com.globalmart.app.exception.CategoryException;

public interface CategoryServices {

	public Category addCategory(Category category)throws CategoryException;
	public Optional<Category> getCategory(Integer categoryId)throws CategoryException;
	public List<Category> getAllCategory()throws CategoryException;
	public Category updateCategory(Category category)throws CategoryException;
	public Boolean deleteCategory(Integer categoryId)throws CategoryException;
	
}
