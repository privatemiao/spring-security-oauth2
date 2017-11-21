package com.imooc.security.core.properties;

import java.util.Arrays;

public class OAuth2Properties {

	private OAuth2ClientProperties[] clients = {};

	private String jwtSigninKey = "imooc";

	public OAuth2Properties() {
	}

	public OAuth2ClientProperties[] getClients() {
		return clients;
	}

	public void setClients(OAuth2ClientProperties[] clients) {
		this.clients = clients;
	}

	public String getJwtSigninKey() {
		return jwtSigninKey;
	}

	public void setJwtSigninKey(String jwtSigninKey) {
		this.jwtSigninKey = jwtSigninKey;
	}

	@Override
	public String toString() {
		return "OAuth2Properties [clients=" + Arrays.toString(clients) + "]";
	}

}
