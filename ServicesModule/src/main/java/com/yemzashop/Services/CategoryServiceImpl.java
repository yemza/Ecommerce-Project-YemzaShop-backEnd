package com.yemzashop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemzashop.Entities.CategoryEntityDAO;
import com.yemzashop.Repository.CategoryEntityDAORepository;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	CategoryEntityDAORepository categoryEntityDAORepository;

	@Override
	public List<CategoryEntityDAO> getAllCategories() {
		// get Data by JPaRepository
		return categoryEntityDAORepository.findAll();
	}

	@Override
	public CategoryEntityDAO getCategoryById(Long categoryId) {
		// get Data by JPaRepository
		return categoryEntityDAORepository.findById(categoryId).get();
	}

}
