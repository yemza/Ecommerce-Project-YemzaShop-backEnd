package com.yemzashop.Controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Entities.CategoryEntityDAO;
import com.yemzashop.Services.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = " CategorieController", tags = { " Categorie Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Categorie Controller", description = "Write description here") })
@RestController
public class CategorieController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<CategoryEntityDAO> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/categorieById")
	public CategoryEntityDAO getCategoryById(@RequestParam Long categoryId) {
		// TODO Auto-generated method stub
		return categoryService.getCategoryById(categoryId);
	}	
	
}
