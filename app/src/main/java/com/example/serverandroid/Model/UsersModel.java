package com.example.serverandroid.Model;

import java.io.Serializable;

public class UsersModel implements Serializable {
    private String _id;
    private String Username;
    private String Email;
    private String PassWord;
    private String Role;
    private Boolean CapQuyen;

    public UsersModel() {
    }

    public UsersModel( String username, String email, String passWord, String role, Boolean capQuyen) {
        Username = username;
        Email = email;
        PassWord = passWord;
        Role = role;
        CapQuyen = capQuyen;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Boolean getCapQuyen() {
        return CapQuyen;
    }

    public void setCapQuyen(Boolean capQuyen) {
        CapQuyen = capQuyen;
    }
}
