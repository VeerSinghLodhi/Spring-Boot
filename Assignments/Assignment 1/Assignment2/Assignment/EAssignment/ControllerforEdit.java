package com.Assignment.Assignment.EAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ControllerforEdit {
    @Autowired
    EnquiryRepository enquiryRepository;

    @GetMapping("/allenquiries")
    public String getallEnquiries(Model model){
        List<EnquiryMaster> enquiryMasters=enquiryRepository.findAll();
        model.addAttribute("enquirylist",enquiryMasters);
        return "allenquiries";
    }

    @GetMapping("/currentenquiry/{id}")
    public String  getCurrent(@PathVariable int id,Model model){
        EnquiryMaster enquiryMaster=enquiryRepository.findById(id).orElse(null);
        if(enquiryMaster!=null){
            model.addAttribute("currentlist",enquiryMaster);
            return "currentenquiry";
        }
        else{
            model.addAttribute("errormessage","Enquiry no "+id+" is not found");
            return "error";
        }
    }


    @PostMapping("/update2")
    public String getUpdateDetail(Model model,@RequestParam String name, @RequestParam int enquiryid, @RequestParam String phone, @RequestParam String message, @RequestParam LocalDate enquiry_date, @RequestParam String subject, @RequestParam String status){
        EnquiryMaster enquiryMaster=enquiryRepository.findById(enquiryid).orElse(null);
        if(enquiryMaster!=null){
            enquiryMaster.setName(name);
            enquiryMaster.setPhone(phone);
            enquiryMaster.setSubject(subject);
            enquiryMaster.setMessage(message);
            enquiryMaster.setEnquiry_date(enquiry_date);
            enquiryMaster.setStatus(status);
            enquiryRepository.save(enquiryMaster);
            return "confirmationpage";
        }else{
            model.addAttribute("errormessage","Enquiry no "+enquiryid+" is not found");
            return "error";
        }
    }
}
