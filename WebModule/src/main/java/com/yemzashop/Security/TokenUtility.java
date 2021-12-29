package com.yemzashop.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtility {
	
	private Long TOKEN_VALIDITY= 604800L;
	private String TOKEN_SECRET= "YemzaSecretShop12345";

	
	public String generateToken (CustomUserDetailsDTO customUserDetailsDTO) {
		
		Map<String , Object> claims = new HashMap<>();
		claims.put("email", customUserDetailsDTO.getEmail());
		claims.put("firstName", customUserDetailsDTO.getFirstName());
		claims.put("lastName", customUserDetailsDTO.getLastName());
		claims.put("idUser", customUserDetailsDTO.getIdUser());


		return Jwts.builder().setClaims(claims)
				.setExpiration(generateExparationDate())
				.signWith(SignatureAlgorithm.HS512 , TOKEN_SECRET)
				.compact();
		
	}

	private Date generateExparationDate() {
		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

}
