package com.assingment.demo.PersonPackage;

public class Person {
    int srno,age;
    String name;
    public Person(int srno,int age,String name){
        this.srno=srno;
        this.age=age;
        this.name=name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
