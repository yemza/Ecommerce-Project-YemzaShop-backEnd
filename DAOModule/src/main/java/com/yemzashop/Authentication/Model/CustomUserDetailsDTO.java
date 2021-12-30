package com.yemzashop.Authentication.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yemzashop.Entities.RoleEntityDAO;
import com.yemzashop.Entities.UserEntityDAO;



public class CustomUserDetailsDTO implements UserDetails,  Serializable{
	
	private static final long serialVersionUID = 1L; 
	private Collection<? extends GrantedAuthority> authorities;
	private Long idUser;
	private String username;
	private String firstName;
	private String lastName;
	private List<RoleEntityDAO> userRoles ;
	private String password;
	private String email;
	
	
	public CustomUserDetailsDTO(Collection<? extends GrantedAuthority> authorities, Long idUser, String username,
			String firstName, String lastName, List<RoleEntityDAO> userRoles, String password, String email) {
		super();
		this.authorities = authorities;
		this.idUser = idUser;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRoles = userRoles;
		this.password = password;
		this.email = email;
	}
	

	public CustomUserDetailsDTO(UserEntityDAO user) {		
		this.authorities = new ArrayList<>(); 
		this.idUser = user.getId();
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userRoles = user.getRoles();
		this.password = user.getPassword();
		this.email = user.getEmail();
	} 
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<RoleEntityDAO> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<RoleEntityDAO> userRoles) {
		this.userRoles = userRoles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

	
	
	
	
	
	
	
	

}
