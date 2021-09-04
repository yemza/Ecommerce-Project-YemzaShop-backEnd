package com.yemzashop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.OrderEntityDAO;

public interface OrderEntityDAORepository  extends JpaRepository<OrderEntityDAO, Long>{

}
