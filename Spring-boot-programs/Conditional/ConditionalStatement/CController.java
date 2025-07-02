package com.example.ConditionalIFELSe.ConditionalStatement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CController {

    @GetMapping("/ternarystatement")
    public String getTernaryStatement(Model model){
        model.addAttribute("isactive",false);
        return "ternarystatement";
    }

    @GetMapping("/elvisstatement")
    public String getElvisStatement(Model model){
        model.addAttribute("isNull",true);
        return "elvisstatement";
    }

    @GetMapping("/ifunlessstatement")
    public String getIfUnlessStatement(Model model){
        model.addAttribute("isEmpty",false);
        return "ifunless_statement";
    }

    @GetMapping("/switchstatement")
    public String getSwitchStatement(Model model){
        model.addAttribute("address","indore");
        return "switchstatement";
    }

    @GetMapping("/loop")
    public String getLoop(Model model){
        List<String> languages=List.of("C","CPP","Java","Python","Java-Script","R",".Net");
        model.addAttribute("languages",languages);
        return "loops";
    }

}
