package com.wkimdev.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
           .antMatchers("/").permitAll()
           .antMatchers("/api/**").authenticated()
//           .and()
//           .formLogin();
//           .httpBasic();
        
     // 버전 3
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();
    }

}
