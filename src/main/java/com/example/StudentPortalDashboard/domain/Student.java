package com.example.StudentPortalDashboard.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullname;
    private String email;
    private String DateEnrolled;

    @OneToMany(mappedBy = "student")
    private List<CourseRegistration> courseRegistrations;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "COURSE_ID") })
    private List<Course> courses;

   /* public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }
    public void removeCourse(Course course) {
        this.getCourses().remove(course);
        course.getStudents().remove(this);
    }
    public void removeCourses() {
        for (Course course : new HashSet<>(courses)) {
            removeCourse(course);
        }
    }*/
}
