package com.yemzashop.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;
import com.yemzashop.Models.JwtRequest;
import com.yemzashop.Models.JwtResponse;
import com.yemzashop.Services.UserService;
import com.yemzashop.Services.UserServiceImpl;
import com.yemzashop.Utility.JWTUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin("*")
@Api(value = "AuthenticationController", tags = { "Authentication Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Authentication Controller", description = "Write description here") })
@RestController
public class AuthenticationController {

	@Autowired
	private JWTUtility jwtUtility;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@PostMapping("/authenticate")
	public JwtResponse Authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							jwtRequest.getUsername(), 
//							jwtRequest.getPassword()
//							)
//					);
			
		UsernamePasswordAuthenticationToken authenticationToken = 
                             new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), 
				                                                     jwtRequest.getPassword());
			
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID DATA " + e + jwtRequest.getUsername() + 
					jwtRequest.getPassword());
		}
		
		final  CustomUserDetailsDTO user = userService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtUtility.generateToken(user);
		
		return new JwtResponse(token);
		
	}
}






















