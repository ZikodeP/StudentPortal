package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Facilitator;
import com.example.StudentPortalDashboard.domain.Student;
import com.example.StudentPortalDashboard.repository.FacilitatorRepository;
import com.example.StudentPortalDashboard.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FacilitatorController {
    @Autowired
    private FacilitatorRepository facilitatorRepository;

    @GetMapping("/addFacilitator")
    public String addFacilitator(Model model)
    {
        Facilitator facilitator = new Facilitator();
        model.addAttribute("facilitator", facilitator);
        return "add_facilitator";
    }

    @PostMapping("/saveFacilitator")
    public String saveFacilitator(@ModelAttribute("facilitator") Facilitator facilitator){
        facilitatorRepository.save(facilitator);
        return "redirect:/getAllFacilitator";
    }

    @GetMapping("/getAllFacilitator")
    public String getAllFacilitators(Model model){
        model.addAttribute("facilitatorList", facilitatorRepository.findAll());
        return "getAllFacilitator";
    }

    @GetMapping("/editFacilitator/{id}")
    public String updateFacilitatorForm(@PathVariable("id") long id, Model model){
        Facilitator facilitator = facilitatorRepository.findById(id).get();
        model.addAttribute("facilitator", facilitator);
        return "update-facilitator";
    }

    @PostMapping("/updateFacilitator/{id}")
    public String updateFacilitator(@PathVariable("id") long id, Facilitator facilitator,
                                BindingResult result) {
        if (result.hasErrors()) {
            facilitator.setId(id);
            return "update-facilitator";
        }
        facilitatorRepository.save(facilitator);
        return "redirect:/getAllFacilitator";
    }

}
