package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("user").antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").loginProcessingUrl("/login").defaultSuccessUrl("/user").and().csrf().disable();
  }


}
