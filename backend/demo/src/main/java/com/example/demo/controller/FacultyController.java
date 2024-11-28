package com.example.demo.controller;

import com.example.demo.entity.Courses;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@Controller
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @PostMapping("/courses")
    public ResponseEntity<Set<Courses>> getAllCoursesByAFacultyCode(@RequestBody Faculty facCode) {
        try {
            String code = facCode.getFacCode();
            Optional<Faculty> faculty = facultyRepository.findByFacCode(code);
            return ResponseEntity.of(Optional.ofNullable(faculty.get().getCourses()));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/ta-list")
    public ResponseEntity<Set<Student>> getAllTAByCourseId(@RequestBody Courses courseId) {
        try {
            Optional<Courses> course = coursesRepository.findCoursesByCourseId(courseId.getCourseId());
            Set<Student> result = course.get().getTa();
            return ResponseEntity.of(Optional.ofNullable(result));
        }catch(Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}