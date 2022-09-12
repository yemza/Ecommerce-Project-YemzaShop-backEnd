package com.yemzashop.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.yemzashop.Entities.UserEntityDAO;
import com.yemzashop.Repository.UserEntityDAORepository;


public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserEntityDAORepository userEntityDAORepository;

	@Override
	public UserEntityDAO getUserById(Long id) {
		try {
		  return userEntityDAORepository.getById(id);
		} catch (Exception e)
		{
		   return null;
		}
	}

}
