package com.sagarmp.sagar.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/getallusers")
public class Reader2 {
    @Autowired
    UserRepository userRepository;
    @GetMapping()
    public List<UserMaster>getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/uiform1")
    public String getAll2(Model model){
        List<UserMaster> lst=userRepository.findAll();
        model.addAttribute("userlist",lst);
        return "userhtml";
    }

    @GetMapping("/orderby")
    public List<UserMaster>getAllSort(){
       // return userRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        Sort sort=Sort.by(Sort.Direction.ASC,"name");
        return userRepository.findAll(sort);
    }
    @GetMapping("/orderby/{user}")
    public List<UserMaster>getAllSortUser(@PathVariable String user){
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,user));
    }

    @GetMapping("/pagination")
    public Page<UserMaster>getPagination(@RequestParam(name="page",defaultValue = "0")int page,@RequestParam(name="size",defaultValue = "5")int size,@RequestParam(name="direction",defaultValue = "asc")String direction,@RequestParam(value = "orderby",defaultValue = "name")String orderby){

        Sort sort;
        if(direction.equals("asc"))
            sort=Sort.by(Sort.Direction.ASC,orderby);
        else
            sort=Sort.by(Sort.Direction.DESC,orderby);
        Pageable pageable= PageRequest.of(page,size,sort);
        return userRepository.findAll((pageable));
    }


}
