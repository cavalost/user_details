package com.cavalos.springboot.message;

import com.cavalos.springboot.model.User;
import java.util.ArrayList;
import java.util.List;

public class ResponseMessage {

    private String message;
    private String url;
    private String error = "";
    private List<User> users = new ArrayList<User>();

    public ResponseMessage(String message, String url, List<User> users) {
        this.message = message;
        this.url = url;
        this.users = users;
    }

    public ResponseMessage(String message, String url, String error) {
        this.message = message;
        this.url = url;
        this.error = error;
    }

    public ResponseMessage(String message, String url) {
        this(message, url, List.of());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

}
