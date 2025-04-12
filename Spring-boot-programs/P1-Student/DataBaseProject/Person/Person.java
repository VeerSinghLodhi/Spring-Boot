package com.DataBase.connect.DataBaseProject.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    int srno;
    String name;
    int salary;

    public Person(int srno, int salary, String name) {
        this.srno = srno;
        this.salary = salary;
        this.name = name;
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



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Person() {
    }
}
