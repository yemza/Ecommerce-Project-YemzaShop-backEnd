package com.yemzashop.Services;

import java.util.List;

import com.yemzashop.Entities.ProductEntityDAO;

public interface ProductService {
	 
	 List<ProductEntityDAO> getAllProducts();
	
	 ProductEntityDAO getProductById(Long productId) ;
	
	 List<ProductEntityDAO> getProductByCategorieId(Long categoryId);

}
