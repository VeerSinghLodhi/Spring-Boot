package com.DataBase.connect.DataBaseProject.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    List<Person>personList=new ArrayList<>();
    @RequestMapping("/veer")
    public String getData(@RequestBody Person newPerson){
        personList.add(newPerson);
        return "New Person Added";
    }
    @GetMapping
    public List<Person> getPersonList(){
        return personList;
    }
}
