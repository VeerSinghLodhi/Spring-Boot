package com.database2.database2.Students;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    int rollno;
    String stuname,gender;

    public Student() {
    }

    public Student(int rollno, String gender, String stuname) {
        this.rollno = rollno;
        this.gender = gender;
        this.stuname = stuname;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
