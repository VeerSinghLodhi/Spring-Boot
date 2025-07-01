package com.naukriforsagar.NaukriForSagar.SecurityPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "Securityhtmls/loginpage";
    }
}
