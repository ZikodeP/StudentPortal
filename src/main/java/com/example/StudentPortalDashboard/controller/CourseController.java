package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Course;
import com.example.StudentPortalDashboard.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/addCourse")
    public String addCourse(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "add_course";
    }

    @PostMapping("saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseRepository.save(course);
        return "redirect:/getAllCourses";
    }

    @GetMapping("/getAllCourses")
    public String getAllCourses(Model model){
        model.addAttribute("courseList", courseRepository.findAll());
        return "getAllCourses";
    }
}
