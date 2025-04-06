package com.assingment.demo.Package1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stu") // End point
public class StudentController2 {
    Map<Integer,Student> studentMap=new HashMap<>();

    @PostMapping
    @ResponseBody
    public String setStudent(@RequestBody Student newStudent){

        studentMap.put(newStudent.getId(),newStudent);
        return "New Student added";
    }

    @GetMapping
    @ResponseBody
    public Map<Integer,Student> getStudent(){
        return studentMap;
    }

    @GetMapping("id/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable int id){
        return studentMap.get(id);
    }

    @DeleteMapping("id/{id}")
    @ResponseBody
    public String getDelete(@PathVariable int id){
        for(int i=0;i<studentMap.size();i++){
            if(studentMap.get(id).getId()==id){
                studentMap.remove(id);
                return "Deleted";
            }
        }
        return "Couldn't Deleted";
    }

    @PutMapping("id/{id}")
    @ResponseBody
    public String getUpdate(@PathVariable int id,@RequestBody Student newStudent){
         studentMap.put(id,newStudent);
         return "Updated";
    }
}
