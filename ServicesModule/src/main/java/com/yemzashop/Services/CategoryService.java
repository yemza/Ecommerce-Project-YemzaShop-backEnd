package com.yemzashop.Services;

import java.util.List;

import com.yemzashop.Entities.CategoryEntityDAO;

public interface CategoryService {
	
	 List<CategoryEntityDAO> getAllCategories();
	 
	 CategoryEntityDAO getCategoryById(Long categoryId);

}
