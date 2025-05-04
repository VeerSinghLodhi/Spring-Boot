package com.sagarmp.sagar.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/showallusers")
public class ReaderController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public Iterable<UserMaster> getshowall(){
        return userRepository.findAll();
    }

    @GetMapping("/username/{username}")
    @ResponseBody
    public List<UserMaster>getUserpass(@RequestParam("username")String username){
        return userRepository.getByUsername(username);
    }


}
