package com.naukriforsagar.NaukriForSagar.CompaniesPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int companyid;

    @NotBlank(message = "Company name cannot be blank")
    private String companyname;

//    @NotBlank(message="Email cannot be blank")
//    @Email()
    private String email;


    private String contact;

    private String address;

    private String description;

    private byte[] companylogo;

    private String password;

    private char status ;

    private Date joining_date;

    public Company() {
    }

    public Company(int companyid, String companyname, String email, String contact, String address, String description, byte[] companylogo, String password, char status, Date date) {
        this.companyid = companyid;
        this.companyname = companyname;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.description = description;
        this.companylogo = companylogo;
        this.password = password;
        this.status = status;
        this.joining_date = date;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(byte[] companylogo) {
        this.companylogo = companylogo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }
}
