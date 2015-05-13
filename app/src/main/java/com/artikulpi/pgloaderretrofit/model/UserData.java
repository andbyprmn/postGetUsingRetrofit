package com.artikulpi.pgloaderretrofit.model;

import java.io.Serializable;

/**
 * Created by abProgrammer on 4/13/15.
 */
public class UserData implements Serializable {
    private String username, email, phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}