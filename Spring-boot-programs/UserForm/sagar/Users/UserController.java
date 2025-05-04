package com.sagarmp.sagar.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/usersform")
    public String getForm(){
        return "registrationform";
    }

    @RequestMapping("/saveuser")
    public String getSaveUser(@RequestParam("name")String name,@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("confirmpassword")String confirmpassword){
        UserMaster userMaster=new UserMaster();
        userMaster.setName(name);
        userMaster.setUsername(username);
        userMaster.setPassword(password);
        userRepository.save(userMaster);
        return "loginpage";
    }

    @RequestMapping("/getloginpage")
    public String getlogin(){
        return "loginpage";
    }

}
