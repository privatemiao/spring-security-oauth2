package com.imooc.security.core.properties;

import org.apache.commons.lang.builder.ToStringBuilder;

public class OAuth2ClientProperties {

	private String clientId;

	private String clientSecret;

	private int accessTokenValiditySeconds;

	public OAuth2ClientProperties() {
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public int getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
