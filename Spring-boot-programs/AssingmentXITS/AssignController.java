package com.practiceprograms.practiceprogram2.AssingmentXITS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class AssignController {
    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    ImageService imageService;

    @RequestMapping("/getpage")
    public String getPage(){
        return "aupload";
    }
    @RequestMapping("/getsagar")
    public String getSagar(){
        return "sagar";
    }

    @PostMapping("/saveuser")
    public String getSave(@RequestParam String fname, @RequestParam String lname, @RequestParam MultipartFile file,@RequestParam String email,@RequestParam String password){
        try {
            imageService.saveimage(fname, lname, email, password, file);
            return "datasaved";
        }catch(IOException e){
            return "error";
        }
    }

    @GetMapping("/thymemodel/{id}")
    public String getTh(Model model, @PathVariable int id)
    {
        Optional<Assignment> lst=assignmentRepository.findById(id);
        model.addAttribute("data",lst.get().getEmail());
        return "thymeexample";
    }

    @GetMapping("/greeting")
    public String getGreeting(Model model){
        model.addAttribute("name","Veer");
        model.addAttribute("age",20);
        return "greeting";
    }

    @GetMapping("/ternarycondition")
    public String getTernary(Model model){
        model.addAttribute("isactive",true);
        model.addAttribute("elvis",true);
        model.addAttribute("ifcondition","yes");
        return "ternary";
    }


    @GetMapping("/loop")
    public String getLoop(Model model){
        List<String> lst=List.of("Java","Python",".Net","Cpp","C","Java Script","Php","DSA","HTML");
        model.addAttribute("lang",lst);
        return "loop";
    }

//    @GetMapping("/sagar")
//    public String getCondition(Model model){
//
//    }
}
