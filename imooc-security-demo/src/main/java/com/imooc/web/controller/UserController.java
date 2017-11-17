package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import com.sun.org.apache.xpath.internal.SourceTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
}
