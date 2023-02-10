package com.example.StudentPortalDashboard.boostrap;

import com.example.StudentPortalDashboard.domain.Facilitator;
import com.example.StudentPortalDashboard.domain.Student;
import com.example.StudentPortalDashboard.repository.FacilitatorRepository;
import com.example.StudentPortalDashboard.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final FacilitatorRepository facilitatorRepository;

    public BoostrapData(StudentRepository studentRepository, FacilitatorRepository facilitatorRepository) {
        this.studentRepository = studentRepository;
        this.facilitatorRepository = facilitatorRepository;
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


        System.out.println("Loading Facilitator Data ...");

        Facilitator f1 = new Facilitator();
        f1.setFullnames("Alvin Hansraj");
        f1.setEmail("Alvin.Hansraj@gmail.com");
        f1.setDateEmployed("2023/02/08");
        f1.setIsAdmin("Yes");
        f1.setFaculty("Accounting");
        f1.setModules("Financial Accounting");

        facilitatorRepository.save(f1);


        System.out.println("Facilitators Saved: " + facilitatorRepository.count());
    }
}