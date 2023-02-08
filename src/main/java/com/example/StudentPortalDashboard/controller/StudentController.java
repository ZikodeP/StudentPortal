package com.example.StudentPortalDashboard.controller;

import com.example.StudentPortalDashboard.domain.Student;
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
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

//    @GetMapping("/addstudent")
//    public String showSignUpForm(Student student){
//        return "add-student";
//    }
//
//    @PostMapping("/addstudent")
//    public String addStudent(Student student, BindingResult result, Model model){
//        if(result.hasErrors()){
//            return "add-student";
//        }
//        studentRepository.save(student);
//        return "redirect:/index";
//    }

    @GetMapping("/addstudent")
    public String addstudent(Model model)
    {
        Student student = new Student();
        model.addAttribute("student",student);
        return "add_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentRepository.save(student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentList(Model model)
    {
        model.addAttribute("studentsList", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"+ id));

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

        studentRepository.save(student);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentRepository.delete(student);
        return "redirect:/index";
    }
}
