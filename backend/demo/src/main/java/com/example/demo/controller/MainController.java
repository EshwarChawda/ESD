package com.example.demo.controller;

import com.example.demo.entity.AddTa;
import com.example.demo.entity.Authentication;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/home")
public class MainController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FacultyService facultyService;


    @PostMapping("/authenticate")
    public String AuthenticateUser(@RequestBody Authentication creds) {
        creds.setMode(1);
        return authenticationService.AuthenticateFaculty(creds.getUsername(), creds.getPassword());
    }

    @PostMapping("/addTa")
    public ResponseEntity<?> addTaByFaculty(@RequestBody AddTa addTa){
        Integer response = facultyService.addTaByFaculty(addTa);
        if(response == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}