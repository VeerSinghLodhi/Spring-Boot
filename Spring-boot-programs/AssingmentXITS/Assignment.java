package com.practiceprograms.practiceprogram2.AssingmentXITS;

import jakarta.persistence.*;

@Entity
@Table(name="assignment")
public class Assignment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int userid;
    String fname,lname,email,password;
    byte [] image;

    public Assignment() {
    }

    public Assignment(int userid, String fname, String lname, String email, String password, byte[] image) {
        this.userid = userid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
