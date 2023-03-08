package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Course;
import com.example.StudentPortalDashboard.domain.CourseRegistration;
import com.example.StudentPortalDashboard.repository.CourseRegistrationRepository;
import com.example.StudentPortalDashboard.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @GetMapping("/getAllCourseRegistrations")
    public String getAllCourseRegistrations(Model model){
        model.addAttribute("CourseRegistrationsList", courseRegistrationRepository.findAll());
        return "getAllCourseRegistrations";
    }

    @GetMapping("/addCourseRegistration")
    public String addCourse(Model model){
        CourseRegistration courseRegistration = new CourseRegistration();
        model.addAttribute("courseRegistration", courseRegistration);
        return "add_courseRegistration";
    }

    @PostMapping("saveCourseRegistration")
    public String saveCourse(@ModelAttribute("courseRegistration") CourseRegistration courseRegistration){
        courseRegistrationRepository.save(courseRegistration);
        return "redirect:/getAllCourseRegistrations";
    }
}
