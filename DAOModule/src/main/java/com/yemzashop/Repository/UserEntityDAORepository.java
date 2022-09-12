package com.yemzashop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yemzashop.Entities.UserEntityDAO;

public interface UserEntityDAORepository  extends JpaRepository<UserEntityDAO, Long>{

	UserEntityDAO findByUsername(String username);
	


	
}
