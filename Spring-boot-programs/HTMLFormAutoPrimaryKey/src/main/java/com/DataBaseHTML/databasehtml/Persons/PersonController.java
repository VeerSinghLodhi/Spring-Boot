package com.DataBaseHTML.databasehtml.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/addperson")
    public String getData() {
        return "addperson";
    }

    @RequestMapping("/formfilled")
    public String getSaveData(@RequestParam("name")String name, @RequestParam("address")String address, @RequestParam("state")String state, @RequestParam("dob")LocalDate dob,@RequestParam("gender")String gender){
        Persons persons=new Persons();
        persons.setName(name);
        persons.setAddress(address);
        persons.setState(state);
        persons.setDob(dob);
        persons.setGender(gender);
        personRepository.save(persons);
        return "redirect:/confirmation.html";
    }
}

