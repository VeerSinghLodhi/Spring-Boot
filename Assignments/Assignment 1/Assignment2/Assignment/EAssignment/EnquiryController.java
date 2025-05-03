package com.Assignment.Assignment.EAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EnquiryController {
    @Autowired
    EnquiryRepository enquiryRepository;
    @RequestMapping("/getenquirypage")
    public String getPage(){
        return "savedata";
    }

    @PostMapping("/esavedata")
    public String getSave(@RequestParam String name,
                          @RequestParam String phone,
                          @RequestParam LocalDate enquiry_date,
                          @RequestParam String message,
                          @RequestParam String subject,
                          @RequestParam String status){

        EnquiryMaster enquiryMaster=new EnquiryMaster();
        enquiryMaster.setName(name);
        enquiryMaster.setPhone(phone);
        enquiryMaster.setEnquiry_date(enquiry_date);
        enquiryMaster.setMessage(message);
        enquiryMaster.setSubject(subject);
        enquiryMaster.setStatus(status);
        enquiryRepository.save(enquiryMaster);
        return "confirmationpage";
    }

    @GetMapping("/getenquirydata")
    public String getEnquiry(Model model){
        List<EnquiryMaster>lst=enquiryRepository.findAll();
        model.addAttribute("enquirylist",lst);
        return "showenquiries";
    }

    @GetMapping("/search")
    public String getSearch(Model model){
        List<EnquiryMaster>lst=enquiryRepository.findAll();
        model.addAttribute("enquirylist",lst);
        return "filter";
    }

    @GetMapping("/searchenquiry")
    public String getSearchBy(Model model,@RequestParam int enquiryid,@RequestParam String name,@RequestParam String status){
        List<EnquiryMaster>lst=enquiryRepository.findByEnquiryidOrNameContainingIgnoreCaseOrStatus(enquiryid,name,status);
        model.addAttribute("enquirylist",lst);
        return "showenquiries";
    }

//    @GetMapping("/searchbyid")
//    public String getSearchById(Model model,@RequestParam int enquiryid){
//        List<EnquiryMaster>lst=enquiryRepository.findByEnquiryid(enquiryid);
//        model.addAttribute("enquirylist2",lst);
//        return "searchBy";
//    }

    @RequestMapping("/getupdate")
    public String getUpdate(){
        return "updateenquiries";
    }

    @PostMapping("/update")
    public String getUpdateDetail(Model model,@RequestParam int enquiryid,@RequestParam String phone,@RequestParam String subject,@RequestParam String status){
        EnquiryMaster enquiryMaster=enquiryRepository.findById(enquiryid).orElse(null);
        if(enquiryMaster!=null){
            enquiryMaster.setPhone(phone);
            enquiryMaster.setSubject(subject);
            enquiryMaster.setStatus(status);
            enquiryRepository.save(enquiryMaster);
            model.addAttribute("savemessage","Updated");
            return "updateenquiries";
        }else{
            model.addAttribute("errormessage","Enquiry no "+enquiryid+" is not found");
            return "error";
        }
    }
}
