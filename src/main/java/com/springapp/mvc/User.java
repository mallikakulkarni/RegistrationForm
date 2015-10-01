package com.springapp.mvc;

import javax.validation.constraints.NotNull;

/**
 * Created by mallika on 9/29/15.
 */
public class User {
    @NotNull
    private String userid;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String secques1;
    private String secAns1;
    private String secques2;
    private String secAns2;
    private String mobile;
    private String address;
    private String interests;

    public User() {}
    public User(String userid, String password, String email, String secques1, String secAns1,
                String secques2, String secAns2, String mobile, String address, String interests) {
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.secques1 = secques1;
        this.secAns1 = secAns1;
        this.secques2 = secques2;
        this.secAns2 = secAns2;
        this.mobile = mobile;
        this.address = address;
        this.interests = interests;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecques1() {
        return secques1;
    }

    public void setSecques1(String secques1) {
        this.secques1 = secques1;
    }

    public String getSecAns1() {
        return secAns1;
    }

    public void setSecAns1(String secAns1) {
        this.secAns1 = secAns1;
    }

    public String getSecques2() {
        return secques2;
    }

    public void setSecques2(String secques2) {
        this.secques2 = secques2;
    }

    public String getSecAns2() {
        return secAns2;
    }

    public void setSecAns2(String secAns2) {
        this.secAns2 = secAns2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public User getPOJOFromInfo() {
        return this;
    }

}
