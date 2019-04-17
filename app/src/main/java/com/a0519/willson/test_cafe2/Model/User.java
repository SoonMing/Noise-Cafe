package com.a0519.willson.test_cafe2.Model;

/**
 * Created by Willson Leow on 23/11/2017.
 */

public class User {
    private String Name;
    private  String Password;
    private String Phone;
    private String IsStaff;

    public User() {
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
        IsStaff= "false";
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
