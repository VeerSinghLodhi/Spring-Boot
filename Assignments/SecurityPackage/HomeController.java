package com.naukriforsagar.NaukriForSagar.SecurityPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/admin/adminDashboard")
    public String getAdminPage(){
        return "Dashboard/admindash";
    }

    @GetMapping("/user/userDashboard")
    public String getUserPage(){
        return "Dashboard/userdash";
    }

    @GetMapping("/worker/workerDashboard")
    public String getWorkerPage(){
        return "Dashboard/workerdash";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage(){
        return "Dashboard/accessdenied";
    }
}
