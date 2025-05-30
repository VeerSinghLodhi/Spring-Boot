package com.naukriforsagar.NaukriForSagar.JobSeekers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {


    @Autowired
    JobSeekerRepository jobSeekerRepository;
    public JobSeekers getSaveData(String name, String email, String contact, String address, MultipartFile profile_picture,MultipartFile resume,String password,String skills)throws IOException {

        JobSeekers jobSeekers=new JobSeekers();
        jobSeekers.setName(name);
        jobSeekers.setEmail(email);
        jobSeekers.setContact(contact);
        jobSeekers.setAddress(address);
        jobSeekers.setProfile_picture(profile_picture.getBytes());
        jobSeekers.setResume(resume.getBytes());
        jobSeekers.setPassword(password);
        jobSeekers.setSkills(skills);
        return jobSeekerRepository.save(jobSeekers);
    }
}
