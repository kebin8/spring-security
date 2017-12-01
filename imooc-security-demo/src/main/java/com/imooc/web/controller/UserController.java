package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistsException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition queryCondition) {

        logger.debug(ReflectionToStringBuilder.toString(queryCondition, ToStringStyle.MULTI_LINE_STYLE));

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> logger.debug(error.getDefaultMessage()));
        }

        logger.debug(user.getId());
        logger.debug(user.getUsername());
        logger.debug(user.getPassword());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> logger.debug(error.getDefaultMessage()));
        }

        logger.debug(user.getId());
        logger.debug(user.getUsername());
        logger.debug(user.getPassword());
        logger.debug(user.getDob().toString());

        user.setId("1");
        return user;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
        throw new UserNotExistsException(id);

//        logger.debug("进入getInfo服务");

//        User user = new User();
//        user.setUsername("tom");
//        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteInfo(@PathVariable String id) {
        logger.debug(id);
    }
}