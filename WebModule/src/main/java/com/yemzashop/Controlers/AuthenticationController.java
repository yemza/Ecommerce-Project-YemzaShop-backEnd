package com.yemzashop.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;
import com.yemzashop.Authentication.Model.JwtRequest;
import com.yemzashop.Authentication.Model.JwtResponse;
import com.yemzashop.Security.TokenUtility;
import com.yemzashop.Services.AuthentificationService;
import com.yemzashop.Services.AuthentificationServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "AuthenticationController", tags = { "Authentication Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentication Controller", description = "Write description here") })
@RestController
public class AuthenticationController {
	@Autowired
	AuthentificationServiceImpl	authentificationService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	TokenUtility tokenUtility;

	@PostMapping("/authenticate")
	public JwtResponse Authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
	    final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword())	
					);
	    SecurityContextHolder.getContext().setAuthentication(authentication);
		CustomUserDetailsDTO userDetails = (CustomUserDetailsDTO) authentificationService.loadUserByUsername(jwtRequest.getUsername());
	return new JwtResponse(userDetails.getIdUser(),tokenUtility.generateToken(userDetails));
	}
		
}






















