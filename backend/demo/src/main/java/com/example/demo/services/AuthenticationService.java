package com.example.demo.services;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private FacultyRepository facultyRepository;

    public boolean AuthenticateFaculty(String username, String password) {
        System.out.println(username);
        Optional<Faculty> faculty = facultyRepository.findByFacCode(username);

        System.out.println(faculty.isPresent());

        return faculty.isPresent();
    }
}