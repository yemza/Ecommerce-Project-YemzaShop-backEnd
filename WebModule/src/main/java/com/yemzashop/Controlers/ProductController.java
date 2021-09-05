package com.yemzashop.Controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Entities.ProductEntityDAO;
import com.yemzashop.Services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "ProductController", tags = { "Product Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Product Controller", description = "Write description here") })
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<ProductEntityDAO> getAllProducts() {
		//Call Product Service Interface
		return productService.getAllProducts();
	}
	
	
	@GetMapping("/productbyId")
	public ProductEntityDAO getProductById(@RequestParam Long productId) {
		//Call Product Service Interface
      return productService.getProductById(productId);
	}
	
	
	@GetMapping("/productbyCatId")
	public List<ProductEntityDAO> getProductByCategorieId(@RequestParam Long categoryId) {
		//Call Product Service Interface
      return productService.getProductByCategorieId(categoryId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
