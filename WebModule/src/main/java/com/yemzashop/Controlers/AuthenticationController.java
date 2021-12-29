package com.yemzashop.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;
import com.yemzashop.Authentication.Model.JwtRequest;
import com.yemzashop.Authentication.Model.JwtResponse;
import com.yemzashop.Security.TokenUtility;
import com.yemzashop.Services.AuthentificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "AuthenticationController", tags = { "Authentication Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentication Controller", description = "Write description here") })
@RestController
public class AuthenticationController {
	@Autowired
	AuthentificationService	authentificationService;
	
	@Autowired
	TokenUtility tokenUtility;

	@PostMapping("/authenticate")
	public JwtResponse Authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		CustomUserDetailsDTO userDetails = authentificationService.authUser(jwtRequest.getUsername(), jwtRequest.getPassword());
	return new JwtResponse(userDetails.getIdUser(),tokenUtility.generateToken(userDetails));
	}
		
}






















