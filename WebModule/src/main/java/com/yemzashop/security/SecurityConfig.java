package com.yemzashop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(1)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	   
	  @Autowired
       private UserDetailsService userDetailsService ;
       
       
    
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//Disable CSRF 
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.authorizeRequests().antMatchers("/login").permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.GET , "/**").hasAnyAuthority("ROLE_Client");
			http.authorizeRequests().anyRequest().authenticated();
			http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
		}
		
		
		@Bean
		@Override
		
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManager();
		}
	
		
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
}