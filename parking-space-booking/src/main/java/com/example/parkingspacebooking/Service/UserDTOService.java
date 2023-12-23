package com.example.parkingspacebooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingspacebooking.Model.UserDTO;
import com.example.parkingspacebooking.Repository.UserDataRepository;



@Service
public class UserDTOService {
	
	private  UserDataRepository userRepository;
	@Autowired
    public UserDTOService(UserDataRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	 public void saveUserData(String userId, String emailId) {
	        UserDTO userDTO = new UserDTO();
	        userDTO.setUserId(userId);
	        userDTO.setEmail(emailId);
	        // Set other user-related data if available

	        userRepository.save(userDTO);
	    }

}
