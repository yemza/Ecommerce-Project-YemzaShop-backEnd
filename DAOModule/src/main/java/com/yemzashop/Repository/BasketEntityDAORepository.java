package com.yemzashop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.BasketEntityDAO;

public interface BasketEntityDAORepository extends JpaRepository<BasketEntityDAO, Long> {

	List<BasketEntityDAO> findAllByUserId(Long idUser);

}

