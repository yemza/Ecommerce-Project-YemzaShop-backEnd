package com.yemzashop.Authentication.Model;

public class JwtResponse {
	
	private Long idUser;
	private String jwtToken;

	
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}


	public JwtResponse(Long idUser, String jwtToken) {
		super();
		this.idUser = idUser;
		this.jwtToken = jwtToken;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getJwtToken() {
		return jwtToken;
	}


	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}


	
}
