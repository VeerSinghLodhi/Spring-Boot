package com.xansa.DBconnect.dbconnect.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller

public class ImagesController {

    @Autowired
    ImagesRepository imagesRepository;


    @Autowired
    ImagesService imagesService;
//    static page ka mapping karna jaruri nhi hota.


    @PostMapping("/uploadimage")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
    try{
        imagesService.saveImage(file);
        return ResponseEntity.ok("Image Uploaded");
    }
    catch (Exception e){
        return ResponseEntity.status(300).body("Error" + e.getMessage());
    }
    }

    @GetMapping("/showimage/{id}")
    public ResponseEntity<byte []> showimage(@PathVariable int id){
        Images img = imagesRepository.findById(id).orElse(null);
        if(img == null){
            throw new RuntimeException("File Not Found");
        }
        else {
            return ResponseEntity.ok()
                    .header("content-type" , "image/jpeg")
                    .body(img.getImg());
        }
    }

    @GetMapping("/allimages")
    public String getAllImages(Model model){
        List<Images> imgs = imagesRepository.findAll();
        model.addAttribute("data", imgs);
        return "imagetable";
    }
}
