package com.yemzashop.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yemzashop.Authentication.Model.CustomUserDetailsDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtility {
	
	private Long TOKEN_VALIDITY= 604800L;
	private String TOKEN_SECRET= "YemzaSecretShop12345";

	
	public String generateToken (CustomUserDetailsDTO customUserDetailsDTO) {
		
		Map<String , Object> claims = new HashMap<>();
		claims.put("username", customUserDetailsDTO.getUsername());
		claims.put("email", customUserDetailsDTO.getEmail());
		claims.put("firstName", customUserDetailsDTO.getFirstName());
		claims.put("lastName", customUserDetailsDTO.getLastName());
		claims.put("idUser", customUserDetailsDTO.getIdUser());


		return Jwts.builder().setClaims(claims)
				.setSubject(customUserDetailsDTO.getUsername())
				.setExpiration(generateExparationDate())
				.signWith(SignatureAlgorithm.HS512 , TOKEN_SECRET)
				.compact();
		
	}
	
	public String getUserNameFromToken(String token) {
		try {
			
		Claims claims = getClaims(token);
		return claims.getSubject();
			
		} catch (Exception e) {
			return null;
		}
	}

	private Date generateExparationDate() {
		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

	public boolean isTokenValid(String token, CustomUserDetailsDTO user) {
		String username = getUserNameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

	public boolean isTokenExpired(String token) {
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}
	
	private Claims getClaims(String token) {
		
		Claims claims;
		try {
			claims=Jwts.parser().setSigningKey(TOKEN_SECRET)
		             .parseClaimsJws(token).getBody();
			
		} catch (Exception e) {
			claims = null;
		}
		
		return claims;
	}


}
