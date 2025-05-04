package com.sagarmp.sagar.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getshow")
public class Reader3 {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public List<UserMaster>getshow(){
        return userRepository.findAll();
    }
    @GetMapping("/orderby")
    public List<UserMaster>getOrderBy(){
        Sort sort=Sort.by(Sort.Direction.ASC,"id");
        return userRepository.findAll(sort);
    }

//    @GetMapping("/orderby")
    @GetMapping("/pagination2")
    public Page<UserMaster>getPag(@RequestParam(name = "page",defaultValue = "0")int page,@RequestParam(name="size",defaultValue = "5")int size,@RequestParam(name="direction",defaultValue = "asc")String direction,@RequestParam(name="orderby",defaultValue = "name")String orderby){
        Sort sort;
        if(direction.equals("asc")){
            sort=Sort.by(Sort.Direction.ASC,orderby);
        }else{
            sort=Sort.by(Sort.Direction.DESC,orderby);
        }
        Pageable pageable= PageRequest.of(page,size,sort);
        return userRepository.findAll((pageable));
    }
}
