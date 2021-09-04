package com.yemzashop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.ProductEntityDAO;

public interface ProductEntityDAORepository extends JpaRepository<ProductEntityDAO, Long>{

}
