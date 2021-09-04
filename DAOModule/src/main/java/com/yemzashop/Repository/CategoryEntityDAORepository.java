package com.yemzashop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.CategoryEntityDAO;

public interface CategoryEntityDAORepository extends JpaRepository<CategoryEntityDAO, Long> {

}
