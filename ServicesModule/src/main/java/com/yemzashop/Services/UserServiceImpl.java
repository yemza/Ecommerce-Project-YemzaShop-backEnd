package com.yemzashop.Services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;
import com.yemzashop.Entities.UserEntityDAO;
import com.yemzashop.Repository.UserEntityDAORepository;

@Service
public class UserServiceImpl implements UserService ,UserDetailsService  {

	@Autowired
	UserEntityDAORepository  userEntityDAORepository ;

	@Transactional
	@Override
	public CustomUserDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntityDAO user = this.userEntityDAORepository.findByUsername(username);
		
		if(user == null) {
			System.out.println(username +" User Not Found");
			throw new UsernameNotFoundException("User Not Found");
		}else {
			System.out.println("user was found" + user.getFirstName() + " email " +user.getEmail());
		}
	   Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//	   user.getRoles().forEach(role ->{
//		   	authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//	   });
	   
//		public CustomUserDetailsDTO(String userName,
//				String firstName, String lastName, String userRole, String password,String jwtToken) 
		
		
		return new CustomUserDetailsDTO(authorities, user.getId(), user.getUsername(), user.getFirstName(), 
				                         user.getLastName(), user.getRoles(), user.getPassword(),user.getEmail(), null);
	
	}
	
	
	
	
	


}
	

