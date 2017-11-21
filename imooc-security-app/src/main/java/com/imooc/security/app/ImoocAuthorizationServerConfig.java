package com.imooc.security.app;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import com.imooc.security.core.properties.OAuth2ClientProperties;
import com.imooc.security.core.properties.SecurityProperties;

@Configuration
@EnableAuthorizationServer
public class ImoocAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/*clients.inMemory().withClient("imooc").secret("imoocsecret").accessTokenValiditySeconds(7200)
				.authorizedGrantTypes("refresh_token", "password").scopes("all", "read", "write").and()
				.withClient("example.com").secret("password").accessTokenValiditySeconds(7200)
				.authorizedGrantTypes("refresh_token", "password").scopes("all", "read", "write");*/
		
		InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
		if (ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())) {
			for (OAuth2ClientProperties config : securityProperties.getOauth2().getClients()) {
				builder.withClient(config.getClientId()).secret(config.getClientSecret()).accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
				.authorizedGrantTypes("refresh_token", "password").scopes("all", "read", "write");
				
			}
		}
		
	}

}
