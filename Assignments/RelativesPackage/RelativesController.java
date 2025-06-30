package com.second.secondbatchVeer.relative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelativesController {
    @Autowired
    RelativesRepository relativesRepository;

    @GetMapping("/shownames/{name}")
    public List<Relatives> showName(@PathVariable String name){
        return relativesRepository.getByName(name);
    }
}
