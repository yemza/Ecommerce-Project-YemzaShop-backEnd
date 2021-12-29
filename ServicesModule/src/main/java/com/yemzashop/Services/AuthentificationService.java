package com.yemzashop.Services;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;

public interface AuthentificationService {

	
	CustomUserDetailsDTO authUser(String username, String password);

}
