package com.example.demo.controller;

import com.example.demo.entity.Authentication;
import com.example.demo.services.AuthenticationService;
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

    @PostMapping("/authenticate")
    public ResponseEntity<?> AuthenticateUser(@RequestBody Authentication creds) {
        creds.setMode(1);
        System.out.println("******************* Reached HERE ! *******************");
        if(authenticationService.AuthenticateFaculty(creds.getUsername(), creds.getPassword())) {
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}