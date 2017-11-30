package com.imooc.exception;

/**
 * Created by kevin on 2017/11/30.
 */
public class UserNotExistsException extends RuntimeException {

    private String id;

    public UserNotExistsException(String id) {
        super("User not exists.");
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
