package com.imooc.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.imooc.security.core.properties.SecurityProperties;

@Configuration
@EnableResourceServer
public class ImoocResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler imoocAuthenticationFailureHandler;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

//		@formatter:off
		http
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
