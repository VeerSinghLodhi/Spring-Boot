package com.DataBaseHTML.databasehtml.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/savedata")
    public String setData(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("salary")double salary){
        Employee employee=new Employee();
        employee.setEmployeeId(id);
        employee.setName(name);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return "redirect:/confirmation.html";
    }

    @RequestMapping("/setemp")
    public String getEmp(){
        return "employees";
    }
}
