package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ToStringBuilder;

public class User {

    public interface UserSimpleView {
    }


    public interface UserDetailView extends UserSimpleView {
    }


    private String username;

    private String password;

    public User() {
    }


    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
