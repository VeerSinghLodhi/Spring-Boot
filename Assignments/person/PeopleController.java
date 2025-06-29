package com.second.secondbatchVeer.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeopleController {

    @Autowired
    PeopleRepository peopleRepository;

    @GetMapping("/signup")
    public String people(){
        return "peopleform";
    }
    @PostMapping("/savepeople")
    public String savepeople(int id, String name, String gender){
        People people=new People();
        people.setId(id);
        people.setName(name);
        people.setGender(gender);
        peopleRepository.save(people);
        return "confirmation";
    }
}
