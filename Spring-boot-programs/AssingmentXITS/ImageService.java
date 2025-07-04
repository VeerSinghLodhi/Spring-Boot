package com.practiceprograms.practiceprogram2.AssingmentXITS;

import com.practiceprograms.practiceprogram2.ImagePackage.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    AssignmentRepository assignmentRepository;

    public Assignment saveimage(String fname, String lname, String email, String password, MultipartFile file) throws IOException
    {
        Assignment assignment=new Assignment();
        assignment.setFname(fname);
        assignment.setLname(lname);
        assignment.setEmail(email);
        assignment.setPassword(password);
        assignment.setImage(file.getBytes());
        return assignmentRepository.save(assignment);
    }
}
