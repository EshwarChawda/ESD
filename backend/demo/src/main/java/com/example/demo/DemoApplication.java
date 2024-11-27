package com.example.demo;

import com.example.demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("***************************\n***************************");
//        MyService myService = new MyService();
//        Optional<Student> student = myService.studentRepository.findStudentByLoginId("S001");
//        System.out.println("Student is present : "+student.isPresent());
//        System.out.println("Student name : "+student.get().getStudentName());

    }

}