package com.example.ConditionalIFELSe.FragmentController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {

    @RequestMapping("/getpage1")
    public String getPage1(){
        return "UseHeaderAndFooter/page1";
    }


    @GetMapping("/getparentpage")
    public String getParent(){
        return "headerandfooter/master";
    }

    @GetMapping("/getchildpage")
    public String getChild(){
        return "UseHeaderAndFooter/child";
    }

    @GetMapping("/getformpage")
    public String getFormPage(){
        return "UseHeaderAndFooter/form";
    }

    @GetMapping("/getjspage")
    public String getJSPage(){
        return "UseHeaderAndFooter/usejs";
    }
}
