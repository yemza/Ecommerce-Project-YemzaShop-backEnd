package com.yemzashop.Authentication.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yemzashop.Entities.RoleEntityDAO;

public class CustomUserDetailsDTO implements UserDetails,  Serializable{
	
	private static final long serialVersionUID = 1L; 
	private Collection<? extends GrantedAuthority> authorities;
	private Long idUser;
	private String userName;
	private String firstName;
	private String lastName;
	private List<RoleEntityDAO> userRoles ;
	private String password;
	private String email;
	private String jwtToken;
	
	
	
	
	
	public CustomUserDetailsDTO(Collection<? extends GrantedAuthority> authorities, Long idUser, String userName,
			String firstName, String lastName, List<RoleEntityDAO> userRoles, String password, String email ,String jwtToken) {
		super();
		this.authorities = authorities;
		this.idUser = idUser;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRoles = userRoles;
		this.password = password;
		this.email = email;
		this.jwtToken = jwtToken;
	}
	
	
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	

}
