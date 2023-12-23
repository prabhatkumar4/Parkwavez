package com.example.userauthenticationmanagement.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userauthenticationmanagement.models.ApplicationUser;
import com.example.userauthenticationmanagement.models.LoginResponseDTO;
import com.example.userauthenticationmanagement.models.Role;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




import com.kafkaProducer.UserDTO;
import com.example.userauthenticationmanagement.repository.UserRepository;


@Service
@Transactional
public class AuthenticationService {

	
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplate2;
    public ApplicationUser registerUser(String username, String password, String firstName, String lastName, String emailId, Role role) {
        String encodedPassword = passwordEncoder.encode(password);
        
        
        UserDTO user2 = new UserDTO();
        user2.setUserId(username);
        user2.setEmail(emailId);
        user2.setUserName(username);
        
        
        
        
        
        ApplicationUser user = new ApplicationUser();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailId(emailId);
        user.setRole(role);

        ApplicationUser savedUser = userRepository.save(user);

        try {
            String userJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(savedUser);
            System.out.println(userJson);

            
            //kafkaTemplate.send("user-registration-topic", userJson);
            kafkaTemplate2.send("user-registration-topic", user2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return savedUser;
    }
    
    
    


    public LoginResponseDTO loginUser(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findByUsername(username).orElse(null), token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }
    }
    public boolean resetPassword(String username, String newPassword) {
        Optional<ApplicationUser> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            ApplicationUser user = optionalUser.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return true;
        }

        return false;
        
    }
    

    


}

