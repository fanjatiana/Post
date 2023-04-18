package com.example.post.model;

public class UserLogin {
    private Long id;
    private String password;
    private String email;

    public UserLogin(String email,String password) {
        this.password = password;
        this.email = email;
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
}
