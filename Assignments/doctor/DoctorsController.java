package com.second.secondbatchVeer.doctor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class DoctorsController {
    @GetMapping("/doctor")
    public String addDoctor(){
        return "doctors";
    }

    @Autowired
    DoctorsRepository doctorsRepository;

    public String convert(String str){
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<str.length();i++){
            s1.append(Character.toLowerCase(str.charAt(i)));
        }
        String []arr = s1.toString().split(" ");
        int len = arr.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=len-1;i++){
            sb.append(Character.toUpperCase(arr[i].charAt(0)));
            sb.append(arr[i].substring(1));
            if(i!=len-1)
                sb.append(' ');
        }
        str= sb.toString();
        return str;
    }

    @PostMapping("/savedoctor")
    public String saved(String name, String specialisation, LocalDate doj, boolean residentdoctor, String gender){
        System.out.println(convert(name));
        System.out.println(specialisation);
        System.out.println(doj);
        System.out.println(residentdoctor);
        System.out.println(gender);
        Doctors d = new Doctors(convert(name),specialisation,doj,gender,residentdoctor);
        doctorsRepository.save(d);
        return "save";
    }
}