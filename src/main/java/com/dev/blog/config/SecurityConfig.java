package com.dev.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.dev.blog.config.auth.PrincipalDetailService;
// Spring Containerでオブジェクトを完了できる。
@Configuration
@EnableWebSecurity // filter
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encoderPWD());
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf().disable() //testする時はcsrfトークンを非活性する
			.authorizeRequests() //request
			.antMatchers("/board/saveForm")
			.access("hasRole('ROLE_ADMIN')")
			.antMatchers("/board/**/updateForm")
			.access("hasRole('ROLE_ADMIN')")
			.antMatchers("/","/board/**","/auth/**", "/js/**", "/css", "/image/**","/error/**") //誰でもOK
			.permitAll() 
			.anyRequest()
			.authenticated()
				.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/login")
				.defaultSuccessUrl("/");
				
		
	}
}
