package com.imooc.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCodeFilter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
		validateCodeFilter.setSecurityProperties(securityProperties);
		validateCodeFilter.afterPropertiesSet();
//		@formatter:off
		http
			.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
			.formLogin()
				.loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.successHandler(imoocAuthenticationSuccessHandler)
				.failureHandler(imoocAuthenticationFailureHandler)
			.and()
			.authorizeRequests()
				.antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(), "/code/image")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.csrf().disable();
//		@formatter:on
	}

}
