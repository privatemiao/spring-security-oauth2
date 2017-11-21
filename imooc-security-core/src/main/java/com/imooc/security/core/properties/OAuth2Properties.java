package com.imooc.security.core.properties;

import java.util.Arrays;

public class OAuth2Properties {

	private OAuth2ClientProperties[] clients = {};

	public OAuth2Properties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OAuth2ClientProperties[] getClients() {
		return clients;
	}

	public void setClients(OAuth2ClientProperties[] clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "OAuth2Properties [clients=" + Arrays.toString(clients) + "]";
	}

}
