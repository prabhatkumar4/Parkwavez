package com.example.userauthenticationmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userauthenticationmanagement.models.LoginResponseDTO;
import com.example.userauthenticationmanagement.models.RegistrationDTO;
import com.example.userauthenticationmanagement.models.ResetPasswordRequestDTO;
import com.example.userauthenticationmanagement.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    
    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationDTO body) {
         authenticationService.registerUser(body.getUsername(), body.getPassword(),body.getFirstName(),body.getLastName(),body.getEmailId(),body.getRole());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
    	
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordRequestDTO resetPasswordRequest) {
        boolean resetSuccessful = authenticationService.resetPassword(resetPasswordRequest.getUsername(), resetPasswordRequest.getNewPassword());

        if (resetSuccessful) {
            return ResponseEntity.ok().body("Password reset successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password reset failed");
        }
    }
}