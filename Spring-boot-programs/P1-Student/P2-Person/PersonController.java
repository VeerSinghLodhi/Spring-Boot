package com.assingment.demo.PersonPackage;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")// End Point
public class PersonController {
    Map<Integer,Person> personMap=new HashMap<>();

    @PostMapping
//    @ResponseBody.   Because we Used RestController(End Point).
    public String addNewPerson(@RequestBody Person newPerson){
        personMap.put(newPerson.getSrno(),newPerson);
        return "New Person Added";
    }

    @GetMapping
    public Map<Integer,Person> getPerson(){
        return personMap;
    }

    @GetMapping("/{id}")
    public Person getPersonBySrno(@PathVariable int srno){
        return personMap.get(srno);
    }
}
