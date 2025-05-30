package com.naukriforsagar.NaukriForSagar.JobSeekers;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="jobseekers")
public class JobSeekers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int jsid;

    @NotBlank(message="Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email()
    private String email;

    @NotBlank(message = "Contact cannot be blank")
    @Pattern(regexp="^(?:(?:\\+91|91|0)[-\\s]?)?[6-9]\\d{9}$",message = "Invalid mobile number")
    private String contact;

    private String address;

    private String password;

    private String skills;

    private byte [] resume;

    @NotNull(message = "Profile picture cannot be null.")
    private byte [] profile_picture;

    public JobSeekers() {
    }

    public JobSeekers(int jsid, String name, String email, String contact, String address, String password, String skills, byte[] resume, byte[] profile_picture) {
        this.jsid = jsid;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.password = password;
        this.skills = skills;
        this.resume = resume;
        this.profile_picture = profile_picture;
    }

    public int getJsid() {
        return jsid;
    }

    public void setJsid(int jsid) {
        this.jsid = jsid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public byte[] getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(byte[] profile_picture) {
        this.profile_picture = profile_picture;
    }
}
