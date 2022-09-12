package com.yemzashop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;
import com.yemzashop.Entities.UserEntityDAO;
import com.yemzashop.Repository.UserEntityDAORepository;



@Service
public class AuthentificationServiceImpl implements  UserDetailsService {
	
	@Autowired
	private UserEntityDAORepository  userEntityDAORepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		 for (UserEntityDAO userEntity : userEntityDAORepository.findAll()) 
//			{
//				userEntity.setPassword(passwordEncoder().encode(userEntity.getPassword()));
//				userEntityDAORepository.save(userEntity);
//				System.out.println("Password:  "+userEntity.getPassword());
//
//			}
//		
		UserEntityDAO user = userEntityDAORepository.findByUsername(username);
		if (user == null) {
			System.out.println("User Login not found : {}" + username);
			return null;
		}
		return new CustomUserDetailsDTO(user);
	}

//	@Override
//	public CustomUserDetailsDTO authUser(String username, String password) {
//		
//
//	final Authentication authentication = authenticationManager.authenticate(
//			new UsernamePasswordAuthenticationToken(username,password)	
//			);
//	SecurityContextHolder.getContext().setAuthentication(authentication);
//	final CustomUserDetailsDTO userDetails = (CustomUserDetailsDTO) loadUserByUsername(username);
//	return userDetails;
//	}
//	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
