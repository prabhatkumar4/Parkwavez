package com.example.notificationservice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.notificationservice.model.NotificationModel;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationModel, BigInteger> {

	List<NotificationModel> findBySpotId(String spotId);
}
