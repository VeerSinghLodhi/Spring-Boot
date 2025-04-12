package com.DataBase.connect.DataBaseProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    int empid;
    String empname;
    int salary;

    public Employee() {
    }

    public Employee(int empid, String empname,int salary) {
        this.empid = empid;
        this.empname = empname;
        this.salary=salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empname;
    }

    public void setEmpName(String empName) {
        this.empname = empName;
    }
}
