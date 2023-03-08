package com.example.StudentPortalDashboard.service.student;

import com.example.StudentPortalDashboard.domain.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public List<Student> getAllStudents();

    public Student findById(Long id);
    public Student updateStudent(Long studentId, Student student);
    public String deleteStudent(Long studentId);
}
