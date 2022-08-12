package com.globalmart.app;



import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dao.CategoryRepo;
import com.globalmart.app.dto.Category;
import com.globalmart.app.exception.CategoryException;
import com.globalmart.app.service.CategoryServices;
import java.util.Optional;


@SpringBootTest
public class CategoreyTest {
	
	@Autowired
	CategoryServices categoryServices;
	
	@Autowired
	CategoryRepo categoryRepository;
	
	
	
	@Test
	public void testAddCategory() throws CategoryException {
		Assumptions.assumeTrue(categoryServices!= null);
		Category category = new Category(102,"earphones","jbl");
		Category category3 = new Category(100,"abcd","abcdef");
		Category categoryDemo = null;
  
			  
		  categoryServices.addCategory(category);
		Optional<Category> category2 = categoryServices.getCategory(102);
		Assertions.assertEquals("earphones",category2.get().getName());
		categoryServices.deleteCategory(102);
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.addCategory(category3));
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.addCategory(categoryDemo));
		
		
}

	@Test
	public void testCategoryGetById() throws CategoryException {
		Assumptions.assumeTrue(categoryServices!= null);
		
		Optional<Category> category = categoryServices.getCategory(2);
		Assertions.assertTrue(category!=null);
		Assertions.assertEquals(2, category.get().getCategoryId());
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.getCategory(7000));
		
		}
	
	@Test
	public void testGetAllCategroies() throws CategoryException {
		Assumptions.assumeTrue(categoryServices!= null);
		List<Category> category = new ArrayList<>();
		category = categoryServices.getAllCategory();	
		Assertions.assertEquals(10,category.size());
		
		
		
}
    	@Test
	public void TestDeleteById() throws CategoryException {
		Assumptions.assumeTrue(categoryServices!= null);
		Optional<Category> category = categoryServices.getCategory(5);
		//categoryServices.deleteCategory(6);
	//	Optional<Category> category2 =s categoryServices.getCategory(6);
		
		Assertions.assertEquals(true,categoryServices.deleteCategory(5));
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.deleteCategory(900));
		categoryServices.addCategory(category.get());
		
	
    	}		
	
		
//		 assertThat(categoryServices.getCategory(6)).isEmpty();
	
		
		
	//}
//	
	@Test
	public void testUpdate() throws CategoryException {
		Assumptions.assumeTrue(categoryServices!= null);
		Category category = new Category(5,"earphone","jbl earphone");
		categoryServices.updateCategory(category);
		Optional<Category> category2 = categoryServices.getCategory(5);
	
		//Assertions.assertEquals("ususi", categoryServices.getCategory(5).getName());
		Assertions.assertEquals("earphone", category2.get().getName());
		Category cate2 = null;
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.updateCategory(cate2));
		Category category3 = new Category(1000,"pilpil","mota ladka");
		Assertions.assertThrows(CategoryException.class,()->this.categoryServices.updateCategory(category3));
		
		
		
	}

	
}
