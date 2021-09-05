package com.yemzashop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemzashop.Entities.ProductEntityDAO;
import com.yemzashop.Repository.ProductEntityDAORepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	 ProductEntityDAORepository  productEntityDAORepository;

	@Override
	public List<ProductEntityDAO> getAllProducts() {
		// return Data From Data with Jpa Repository
		return productEntityDAORepository.findAll();
	}

	@Override
	public ProductEntityDAO getProductById(Long productId) {
		// return Data From Data with Jpa Repository
		return productEntityDAORepository.findById(productId).get();
	}

	@Override
	public List<ProductEntityDAO> getProductByCategorieId(Long categoryId) {
		// return Data From Data with Jpa Repository
		return productEntityDAORepository.findByCategoryEntityDAOId(categoryId);
	}
	
	
	

}
