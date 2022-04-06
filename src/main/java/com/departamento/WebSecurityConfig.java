package com.departamento;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	  @Autowired 
	  private DataSource dataSource;
	  
	  @Autowired 
	  private BCryptPasswordEncoder passEnconder;
	  
	  @Autowired
	  public void configurerSecurityGobal(AuthenticationManagerBuilder builder)
	  throws Exception { 
		  
	   builder.jdbcAuthentication() .dataSource(dataSource)
	  .passwordEncoder(passEnconder)
	  .usersByUsernameQuery("SELECT u.username, u.password, u.enable FROM users u WHERE u.username =?"
	  )
	  .authoritiesByUsernameQuery("SELECT r.user_id, r.rolname FROM roles r inner join users u on r.user_id=u.id where u.username=?");
	   
	  }
	 
}


