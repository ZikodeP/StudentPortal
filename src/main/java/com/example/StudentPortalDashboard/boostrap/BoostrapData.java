package com.example.StudentPortalDashboard.boostrap;

import com.example.StudentPortalDashboard.domain.*;
import com.example.StudentPortalDashboard.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BoostrapData implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final FacilitatorRepository facilitatorRepository;
    private final AdminRepository administratorRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    public BoostrapData(StudentRepository studentRepository,
                        FacilitatorRepository facilitatorRepository,
                        AdminRepository administratorRepository,
                        CourseRepository courseRepository,
                        CourseRegistrationRepository courseRegistrationRepository) {

        this.studentRepository = studentRepository;
        this.facilitatorRepository = facilitatorRepository;
        this.administratorRepository = administratorRepository;
        this.courseRepository = courseRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
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

        System.out.println("Students Saved: " + studentRepository.count());


        System.out.println("Loading Facilitator Data ...");

        Facilitator f1 = new Facilitator();
        f1.setEmployeeNumber("21445232");
        f1.setFullnames("Alvin Hansraj");
        f1.setEmail("Alvin.Hansraj@gmail.com");
        f1.setDateEmployed("2023/02/08");
        f1.setIsAdmin("Yes");
        f1.setFaculty("Accounting");
        f1.setModules("Financial Accounting");

        facilitatorRepository.save(f1);


        System.out.println("Facilitators Saved: " + facilitatorRepository.count());


        System.out.println("Loading Administrator Data ...");

        Administrator admin1 = new Administrator();
        admin1.setEmployeNumber("31331485");
        admin1.setFullnames("Robert Amstrong");
        admin1.setEmail("Robert.Amstrong@gmail.com");
        admin1.setDateCreated("2023/02/08");
        admin1.setDateOfBirth("1985/02/08");

        administratorRepository.save(admin1);

        Administrator admin2 = new Administrator();
        admin2.setEmployeNumber("31221485");
        admin2.setFullnames("Mike Stuart");
        admin2.setEmail("Mike.Stuart@gmail.com");
        admin2.setDateCreated("2023/02/08");
        admin2.setDateOfBirth("1987/05/16");

        administratorRepository.save(admin2);


        System.out.println("Administrators Saved: " + administratorRepository.count());

        System.out.println("Loading Courses Data ...");

        Course course1 = new Course();
        course1.setCourseDesc("Information technology is the use of computers to create, process, store, retrieve and exchange all kinds of data and information. IT forms part of information and communications technology.");
        course1.setUnits(30);
        course1.setCourseDetails("Information technology (IT) is the use of computer systems or devices to access information. Information technology is responsible for such a large portion of our workforce, business operations and personal access to information that it comprises much of our daily activities.");

        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setCourseDesc("Operations management plays an essential role in the success of any organisation. However, the role of an operations manager has become increasingly complex with the advent or awareness of factors, including climate change, the Fourth Industrial Revolution, and the enhanced automation made possible by improved technologies and artificial intelligence. Our short course in Operations Management provides an introduction to the current challenges faced in operations management, and the nature of online short courses allows for convenient updating of themes and issues covered as this dynamic landscape continues to evolve.");
        course2.setUnits(30);
        course2.setCourseDetails("Operations management oversees the complete operating system of an organization. Operations management is essential for organizations to manage their daily activities seamlessly. Operations management controls all the processes and handles issues including design, operation, maintenance, and improvement of the systems.");

        courseRepository.save(course2);

        System.out.println("Courses Saved: " + courseRepository.count());

        System.out.println("Loading Courses Registrations Data ...");

       /* List<Course> courses = (List<Course>) courseRepository.findAll();
        System.out.println("Testing get course ... " + courses.get(1));

        List<Student> students = (List<Student>) studentRepository.findAll();
        System.out.println("Testing get student ... " + students.get(1));

        CourseRegistration courseRegistration1 = new CourseRegistration();
        courseRegistration1.setCourse(courses.get(0));
        courseRegistration1.setStudent(students.get(1));
        courseRegistration1.setGrade(1);
        courseRegistration1.setDateRegistered(LocalDateTime.now());

        courseRegistrationRepository.save(courseRegistration1);

        CourseRegistration courseRegistration2 = new CourseRegistration();

        courseRegistration2.setCourse(courses.get(1));
        courseRegistration2.setStudent(students.get(2));
        courseRegistration2.setGrade(2);
        courseRegistration2.setDateRegistered(LocalDateTime.now().minusDays(2L));

        courseRegistrationRepository.save(courseRegistration2);

        System.out.println("Course Registrations Saved: " + courseRegistrationRepository.count());*/
    }
}