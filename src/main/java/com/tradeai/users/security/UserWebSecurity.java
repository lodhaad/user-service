package com.tradeai.users.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class UserWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	// permit url from some hosts

	public UserWebSecurity(Environment environment) {

		this.environment = environment;
	}

	
	
	@Override
	 
	 protected void configure(HttpSecurity info) throws Exception {
	 
	 info.csrf().disable();
	 
	  info.authorizeRequests().antMatchers("/users/**").permitAll();
	  
	  
	  
	  }
	  
	  
	 
	
	/*
	
	@Override

	protected void configure(HttpSecurity info) throws Exception {

		info.csrf().disable();

		info.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip"));

	}
	
	*/
	

}
