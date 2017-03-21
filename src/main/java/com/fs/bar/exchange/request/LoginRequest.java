package com.fs.bar.exchange.request;

import javax.validation.constraints.NotNull;

/**
 * Created by fengsong on 2017/3/16.
 */
public class LoginRequest  {

    @NotNull(message = "用户名不能为空")
    private String username;
    private String password;
    private String validCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
