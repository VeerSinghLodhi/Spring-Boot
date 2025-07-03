package com.naukriforsagar.NaukriForSagar.FooterAndHeader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {

    @GetMapping("/header")
    public String getHeader(){
        return "HeaderAndFooter/header";
    }

    @GetMapping("/footer")
    public String getFooter(){
        return "HeaderAndFooter/footer";
    }

}
