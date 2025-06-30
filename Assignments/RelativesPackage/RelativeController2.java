package com.second.secondbatchVeer.relative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RelativeController2 {
    @Autowired
    RelativeRepository2 r;

    @GetMapping("/showallrelatives")
    public String showAllRelatives(Model model){
        List<Relatives> relativesList=(List<Relatives>) r.findAll(Sort.by("name"));
        model.addAttribute("list1",relativesList);
        return "showallrelatives";
    }
}
