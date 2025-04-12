package com.DataBase.connect.DataBaseProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    public Users() {
    }

    @Id
    int userid;
    String username;
    public Users(int userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
