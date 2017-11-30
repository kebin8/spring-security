package com.imooc.web.controller;

import com.imooc.exception.UserNotExistsException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Created by kevin on 2017/11/30.
 */
@ControllerAdvice
public class ControllerExceptionHander {

    @ResponseBody
    @ExceptionHandler(UserNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handerUserNotException(UserNotExistsException ex) {
        Map<String, Object> result = new HashedMap();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}