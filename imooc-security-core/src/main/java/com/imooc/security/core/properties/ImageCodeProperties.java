package com.imooc.security.core.properties;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ImageCodeProperties {

	private int width = 67;

	private int height = 23;

	private int length = 4;

	private int expireIn = 60;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ImageCodeProperties() {
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
