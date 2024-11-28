package com.example.demo.services;

import com.example.demo.entity.Faculty;
import com.example.demo.helper.JWTHelper;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private FacultyRepository facultyRepository;

    public String AuthenticateFaculty(String username, String password) {
        Optional<Faculty> faculty = facultyRepository.findByFacCode(username);
        if(faculty.isPresent() && faculty.get().getPassword().equals(password) ) {
            return jwtHelper.generateToken(username);
        }
        return "Inavlid username or password";
    }
}