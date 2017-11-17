package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    public interface UserSimpleView {
    }


    public interface UserDetailView extends UserSimpleView {
    }

    private String id;

    @NotBlank(message = "用户名不能为空")
    @MyConstraint(message = "用户名已经存在")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

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

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
