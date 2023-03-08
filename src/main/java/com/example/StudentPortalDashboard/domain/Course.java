package com.example.StudentPortalDashboard.domain;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long courseId;

    @Lob
    @Column(name="courseDesc", length=1024)
    public String courseDesc;

    public int units;

    @Lob
    @Column(name="courseDetails", length=1024)
    public String courseDetails;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
