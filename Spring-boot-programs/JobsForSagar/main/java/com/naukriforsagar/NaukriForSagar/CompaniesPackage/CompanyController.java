package com.naukriforsagar.NaukriForSagar.CompaniesPackage;

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

import java.time.LocalDate;
import java.util.Date;

@Controller
public class CompanyController {


    @GetMapping("/getcompanypage")
    public String getCompanyPage(Model model){
        model.addAttribute("comdata",new Company());
        return "RegistrationForm/companyform";
    }

    @Autowired CompanyLogoService companyLogoService;

    @PostMapping("/savecompanydata")
    public String getSaveCompannyDetails(@Valid @ModelAttribute("comdata") Company company, BindingResult bindingResult, @RequestParam String companyname, @RequestParam String email, @RequestParam String contact, @RequestParam String address, @RequestParam String description, @RequestParam String password , @RequestParam MultipartFile companylogo){

        if(bindingResult.hasErrors()){
            System.out.println("Inside the If");
            return "RegistrationForm/companyform";
        }
        else {
            System.out.println("Inside the Else");
            try {
                Date date = new Date();
                System.out.println(date);
                companyLogoService.getSaveDetails(companyname, email, contact, address, description, companylogo, password, date, 'Y');
                return "datasaved";
            } catch (Exception e) {
                return "error";
            }
        }
    }

}
