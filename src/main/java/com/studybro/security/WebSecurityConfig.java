package com.studybro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.studybro.repositories.NeoPersistentTokenRepositoryImpl;
import com.studybro.repositories.RememberMeTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	 	@Autowired
	    @Qualifier("customUserDetailsService")
	    UserDetailsService userDetailsService;
	    @Autowired
	    RememberMeTokenRepository  rememberMeTokenRepository;
	     
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable().authorizeRequests()
			.and()
	        .antMatchers("/user/register").permitAll()
	        .antMatchers("/","/sb", "/**.html", "/**.js","/**/**.html", "/**/**.js","/**/**.css","/**/**.png","/**/**.jpg").permitAll()
	        .antMatchers(HttpMethod.POST, "/user/login").permitAll()
	        .antMatchers("/video/free").permitAll()
	       // .anyRequest().authenticated()
	        .and()
	        // We filter the api/login requests
	        .addFilterBefore(new JWTLoginFilter("/user/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
	        // And filter other requests to check the presence of JWT in header
	        .addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
			
	    
	  //remember me configuration
	  	/*	http.rememberMe().
	  		key("rem-me-key").
	  		tokenRepository(persistentTokenRepository()).
	                  rememberMeParameter("remember-me-param").
	                  rememberMeCookieName("sb-remember-me").
	                  tokenValiditySeconds(86400);*/
	  }

	 /* @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    // Create a default account
	    auth.inMemoryAuthentication()
	        .withUser("admin")
	        .password("password")
	        .roles("ADMIN");

	  }*/
	
	 
	     
	    @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	        auth.authenticationProvider(authenticationProvider());
	    }
	     
	     
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	     
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService);
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }
	    @Bean
		public PersistentTokenRepository persistentTokenRepository() {
			NeoPersistentTokenRepositoryImpl tokenRepository = new NeoPersistentTokenRepositoryImpl(rememberMeTokenRepository);
			return tokenRepository;
		}
}
