package com.example.parkingspacebooking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.parkingspacebooking.Model.UserDTO;

public interface UserDataRepository extends MongoRepository<UserDTO, String>{

}
