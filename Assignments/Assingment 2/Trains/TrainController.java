package com.practice.practiceProgram.Trains;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrainController {
    @Autowired
    TrainRepository trainRepository;
    @GetMapping("/trains")
    public String getTrains(Model model){
        List<TrainMaster> lst=trainRepository.findAll();
        model.addAttribute("trainlist",lst);
        return "sagar";
    }

    @GetMapping("/search")
    public String getSearch(){
        return "search";
    }

    @GetMapping("/searchresult")
    public String getSearchResult(Model model, @RequestParam int tno,@RequestParam String source){
        List<TrainMaster>lst=trainRepository.findByTnoOrSourceContainingIgnoreCase(tno,source);
        model.addAttribute("trainlist",lst);
        return "sagar";
    }

    @GetMapping("/updatetrains")
    public String getUpdate(){
        return "updateTrains";
    }

    @PostMapping("/update")
    public String getupdate(Model model,@RequestParam int tno,@RequestParam String tname,@RequestParam String source,@RequestParam String destination){
        TrainMaster trainMaster=trainRepository.findById(tno).orElse(null);
        if(trainMaster!=null){
            trainMaster.setTname(tname);
            trainMaster.setSource(source);
            trainMaster.setDestination(destination);
            trainRepository.save(trainMaster);
            model.addAttribute("savemessage","Updated");
            return "updateTrains";
        }
        else{
            model.addAttribute("" + "Train No. "+tno+" is not found");
            return "error";
        }
    }
}
