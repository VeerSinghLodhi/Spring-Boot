package com.naukriforsagar.NaukriForSagar.JobSeekers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class JobSeekerController {

    @Autowired
    JobSeekerRepository jobSeekerRepository;

    @GetMapping("/getjobseekerpage")
    public String getRegistrationForm(Model model){
        model.addAttribute("jsdata",new JobSeekers());
        return "RegistrationForm/jobseekerform";
    }

    @Autowired
    ImageService imageService;

    @PostMapping("/savejobseeker")
    public String getSaveJobSeekerDetails(@Valid @ModelAttribute("jsdata") JobSeekers jobSeekers, BindingResult bindingResult, @RequestParam String name, @RequestParam String email, @RequestParam String contact, @RequestParam String address, @RequestParam MultipartFile profile_picture, @RequestParam MultipartFile resume, @RequestParam String password, @RequestParam String skills){
        if(bindingResult.hasErrors()){
            System.out.println("This is (If) part");
            return "RegistrationForm/jobseekerform";
        }else {
            System.out.println("This is (Else) part");
            try {
                imageService.getSaveData(name, email, contact, address, profile_picture, resume, password, skills);
                return "datasaved";
            } catch (Exception e) {
                return "error";
            }
        }
    }
}
