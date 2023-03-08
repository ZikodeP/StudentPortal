package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Student;
import com.example.StudentPortalDashboard.repository.StudentRepository;
import com.example.StudentPortalDashboard.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/addstudent")
    public String addstudent(Model model)
    {
        Student student = new Student();
        model.addAttribute("student",student);
        return "add_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentList(Model model)
    {
        model.addAttribute("studentsList", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-user";
        }

        studentService.updateStudent(id, student);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentService.findById(id);
        if(student != null) {
            studentService.deleteStudent(id);
        }
        return "redirect:/index";
    }
}
