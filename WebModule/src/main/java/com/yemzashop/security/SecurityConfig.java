package com.yemzashop.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final String[] PUPLIC_ENDPOINTS = {
			"/authenticate"
	};
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
    	 http
    	.cors()
    	.and()
    	.csrf()
    	.disable()
    	.sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and()
    	.authorizeRequests()
    	.antMatchers(PUPLIC_ENDPOINTS)
    	.permitAll()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.addFilterBefore(authentificationRequestFilter() , 
    			         UsernamePasswordAuthenticationFilter.class);
    	
    }
    
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public AuthentificationRequestFilter authentificationRequestFilter() {
    	return new AuthentificationRequestFilter();

	}

}