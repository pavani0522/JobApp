package com.pavs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationProvider authprovider() {
		
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(7));
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		/*
		 * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new
		 * Customizer<CsrfConfigurer<HttpSecurity>>() {
		 * 
		 * @Override public void customize(CsrfConfigurer<HttpSecurity> configurer) { //
		 * TODO Auto-generated method stub configurer.disable(); } };
		 * 
		 * http.csrf(custCsrf);
		 * 
		 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry> auth= new
		 * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry>() {
		 * 
		 * @Override public void
		 * customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		 * AuthorizationManagerRequestMatcherRegistry registry) { // TODO Auto-generated
		 * method stub registry.anyRequest().authenticated();
		 * 
		 * } };
		 * 
		 * http.authorizeHttpRequests(auth);
		 */
		
		
		
		  http
		  .csrf(customizer -> customizer.disable())
		  .authorizeHttpRequests(request -> request.anyRequest().authenticated())
		  .httpBasic(Customizer.withDefaults())
		  .sessionManagement(session ->
		   session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin(Customizer.withDefaults());
		  return	http.build();
	}
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user= org.springframework.security.core.userdetails.User
//				              .withDefaultPasswordEncoder()
//				              .username("tej")
//				              .password("tej123")
//				              .roles("USER")
//				              .build();
//		
//		UserDetails admin= org.springframework.security.core.userdetails.User
//	              .withDefaultPasswordEncoder()
//	              .username("avi")
//	              .password("avi123")
//	              .roles("ADMIN")
//	              .build();
//				
//		return new InMemoryUserDetailsManager(user,admin);
//	}

}
