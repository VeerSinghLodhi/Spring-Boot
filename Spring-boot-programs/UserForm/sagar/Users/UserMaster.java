package com.sagarmp.sagar.Users;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserMaster {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name,username,password;

    public UserMaster() {
    }

    public UserMaster(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
