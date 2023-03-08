package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Administrator;
import com.example.StudentPortalDashboard.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;
    @RequestMapping("/getAllAdministrator")
    public String index(Model model)
    {
        model.addAttribute("administratorList", adminRepository.findAll());
        return "getAllAdministrator";
    }

    @GetMapping("/addAdmin")
    public String addAdmin(Model model){
        Administrator admin = new Administrator();
        model.addAttribute("administrator", admin);
        return "addAdmin";
    }
}
