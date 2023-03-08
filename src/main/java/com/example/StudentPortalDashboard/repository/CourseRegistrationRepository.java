package com.example.StudentPortalDashboard.repository;

import com.example.StudentPortalDashboard.domain.CourseRegistration;
import org.springframework.data.repository.CrudRepository;

public interface CourseRegistrationRepository extends CrudRepository <CourseRegistration, Long> {
}
