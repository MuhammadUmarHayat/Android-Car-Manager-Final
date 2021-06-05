package com.example.carexpensemanagerfinal1;

public class Users {
    String name;
    String userid;
    String password;
    String mobile;
    String email;

    public Users() {
    }

    public Users(String name, String userid, String password, String mobile, String email)

    {
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
