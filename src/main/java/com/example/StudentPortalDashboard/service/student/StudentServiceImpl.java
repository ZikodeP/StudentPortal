package com.example.StudentPortalDashboard.service.student;

import com.example.StudentPortalDashboard.domain.Course;
import com.example.StudentPortalDashboard.domain.Student;
import com.example.StudentPortalDashboard.repository.CourseRepository;
import com.example.StudentPortalDashboard.repository.StudentRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseRepository courseRepository)
    {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    @Override
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        return students;
    }

    @Override
    public Student findById(Long id) {
        return  studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:"+ id));
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentDto = studentRepository.findById(studentId).get();
        mapStudentToDto(student, studentDto);
        Student studentResult = studentRepository.save(studentDto);
        return studentResult;
    }

    private void mapStudentToDto(Student student, Student studentDto) {
        studentDto.getCourses().clear();
        studentDto.setFullname(student.getFullname());
        studentDto.setEmail(student.getEmail());
        studentDto.setDateEnrolled(student.getDateEnrolled());
        studentDto.setCourses(student.getCourses());
        studentDto.setCourseRegistrations(student.getCourseRegistrations());
    }

    @Override
    public String deleteStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        //Remove the related courses from student entity.
        if(student.isPresent()) {
            courseRepository.findAll().forEach(course -> {
                Course courseObj = courseRepository.findById(course.getCourseId()).get();
                if(courseObj != null){
                    courseRepository.delete(courseObj);
                }
            });
            studentRepository.deleteById(student.get().getId());
            return "Student with id: " + studentId + " deleted successfully!";
        }
        return null;
    }
}
