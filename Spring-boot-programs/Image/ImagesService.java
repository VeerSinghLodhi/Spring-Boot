package com.xansa.DBconnect.dbconnect.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagesService {
    @Autowired
    ImagesRepository imagesRepository;

    public Images saveImage(MultipartFile file) throws Exception{
        Images img = new Images();
        img.setName(file.getOriginalFilename());//for image name.
        img.setImg(file.getBytes());
        return  imagesRepository.save(img);//return img too is an option.
    }
}
