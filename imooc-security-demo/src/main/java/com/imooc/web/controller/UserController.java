package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {

    //    RequestBody: 解析传过来的字符串格式的JSON
    @PostMapping
    @ApiOperation("用户创建服务")
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user);
        user.setId("1");
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation("用户编辑服务")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                System.out.println(String.format("%s: %s", ((FieldError) error).getField(), error.getDefaultMessage()));
            });
        }

        System.out.println(user);
        user.setId("1");
        return user;
    }

    @DeleteMapping("{id}")
    @ApiOperation("用户删除服务")
    public void delete(@PathVariable String id){
        System.out.println(String.format("Will delete user id=%s", id));
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation("用户查询服务")
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1, size = 20, sort = "username", direction = Sort.Direction.ASC) Pageable page) {
        System.out.println(condition);
        System.out.println(String.format("PageSize: %d, PageNumber: %d, PageSort: %s", page.getPageSize(), page.getPageNumber(), page.getSort()));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id}")
    @JsonView(User.UserDetailView.class)
    @ApiOperation("获取用户详情服务")
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
        /*if (true){
            throw new RuntimeException("User not exist");
        }*/
        User user = new User();
        user.setUsername("tom");
        return user;
    }
    
    @GetMapping("/me")
    public Object getCurrentUser(Authentication user) {
    	return user;
    }
}
