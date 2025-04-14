package com.database2.database2.Assignment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Marksheet {
    @Id
    int admno;
    String name,result;
    double mark1,mark2,total,average;
    public int getAdmno() {
        return admno;
    }
    public void setAdmno(int admno) {
        this.admno = admno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public double getMark1() {
        return mark1;
    }
    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }
    public double getMark2() {
        return mark2;
    }
    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public Marksheet() {
    }
}
