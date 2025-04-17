package com.DataBaseHTML.databasehtml.Persons;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="persons")
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int srno;
    String name;
    String address;
    String state;
    LocalDate dob;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    String gender;

    public Persons() {
    }

    public Persons(int srno, String name, String address, String state,String gender,LocalDate dob) {
        this.srno = srno;
        this.name = name;
        this.address = address;
        this.state = state;
        this.gender=gender;
        this.dob=dob;
    }

    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
