package com.example.demo.services;

import com.example.demo.entity.AddTa;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoursesRepository courseRepository;

    public Integer addTaByFaculty(AddTa addTa){
        Optional<Faculty> fOptional = facultyRepository.findByFacCode(addTa.getFacultyCode());
        Optional<Courses> courses1 = courseRepository.findCoursesByCourseId(Long.valueOf(addTa.getCourseCode()));
        if(fOptional.isPresent()){
            fOptional.get().getCourses().forEach(course -> {
                if(course.getCourseCode().equals(courses1.get().getCourseCode())){
                    if(course.getTa().size() < course.getMaxTA()){
                        Optional<Student> sOptional = studentRepository.findByStudentRollNo(addTa.getTaRollNo());
                        if(sOptional.isPresent()){
                            Student student = sOptional.get();
                            course.getTa().add(student);
                            courseRepository.save(course);
                        }
                    }
                }
            });
        }
        return 1;
    }

}
