package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UserQueryCondition {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("年龄最大值")
    private int ageTo;

    public UserQueryCondition() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
