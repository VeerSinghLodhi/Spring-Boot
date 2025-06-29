package com.second.secondbatchVeer.doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int docid;
    String name,specialisation,gender;
    LocalDate doj;
    boolean residentdoctor;

    public Doctors() {
    }

    public Doctors(String name, String specialisation, LocalDate doj, String gender, boolean residentdoctor) {
        this.name = name;
        this.specialisation = specialisation;
        this.doj = doj;
        this.gender = gender;
        this.residentdoctor = residentdoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isResidentdoctor() {
        return residentdoctor;
    }

    public void setResidentdoctor(boolean residentdoctor) {
        this.residentdoctor = residentdoctor;
    }
}
