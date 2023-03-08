package com.example.StudentPortalDashboard.repository;

import com.example.StudentPortalDashboard.domain.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Administrator, Long> {
}
