package com.assingment.demo.Package1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {
    List<Student> studentLIst=new ArrayList<>();

    @PostMapping
    @ResponseBody
    public String addStudent(@RequestBody Student newStudent){
        studentLIst.add(newStudent);
        return "New Student Added";
    }
    @GetMapping
    @ResponseBody
    public List<Student> getStudents(){
        return studentLIst;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String getDeleteStudent(@PathVariable int id){
        studentLIst.removeIf(studentLIst->studentLIst.getId()==id);
        return "Student Deleted!";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable int id){
      //  return studentLIst.stream().filter(student->student.getId()==id).collect(Collectors.toList());
        for(int i=0;i<studentLIst.size();i++){
            if(studentLIst.get(i).getId()==id){
                return studentLIst.get(i);
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String getUpdate(@PathVariable int id,@RequestBody Student newStudent){
        for (int i=0;i<studentLIst.size();i++){
            if(studentLIst.get(i).getId()==id){
                studentLIst.add(newStudent);
                return "Updated";
            }
        }
        return "couldn't Updated";
    }

    
}
