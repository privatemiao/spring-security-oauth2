package com.imooc.security.core.properties;

public class BrowserProperties {
    private String loginPage = "/imooc-signin.html";

    public BrowserProperties() {
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
