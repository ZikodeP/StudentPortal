package com.example.StudentPortalDashboard.boostrap;

import com.example.StudentPortalDashboard.domain.Student;
import com.example.StudentPortalDashboard.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public BoostrapData( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Student Data ...");

        Student s1 = new Student();
        s1.setFullname("Thabane Lunga");
        s1.setEmail("Lungapt@gmail.com");
        s1.setDateEnrolled("2023/02/08");
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setFullname("Hishaam Kamish");
        s2.setEmail("Hishaam.Kamish@gmail.com");
        s2.setDateEnrolled("2023/02/08");
        studentRepository.save(s1);

        Student s3 = new Student();
        s3.setFullname("David Parker");
        s3.setEmail("David.Parker@gmail.com");
        s3.setDateEnrolled("2023/02/08");
        studentRepository.save(s3);

        System.out.println("Customers Saved: " + studentRepository.count());
    }
}