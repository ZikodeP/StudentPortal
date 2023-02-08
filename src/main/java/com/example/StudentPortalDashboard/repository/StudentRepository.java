package com.example.StudentPortalDashboard.repository;

import com.example.StudentPortalDashboard.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
