package com.example.parkingspacebooking.kafkaConsumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.parkingspacebooking.Model.UserDTO;
import com.example.parkingspacebooking.Repository.UserDataRepository;
import com.example.parkingspacebooking.Service.BookingService;
import com.example.parkingspacebooking.Service.UserDTOService;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	private  UserDTOService userDTOService;
	
	  @Autowired
	    public KafkaConsumer(UserDTOService userDTOService) {
	        this.userDTOService = userDTOService;
	    }
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserDataRepository userRepository;
	
	public void saveUserToMongoDB(UserDTO user) {
	    // Use your MongoDB repository to save the user data
	    userRepository.save(user);
	    LOGGER.info("User data saved to MongoDB.");
	}



    @KafkaListener(topics = "user-registration-topic",
                    groupId = "14")
    public void consume(UserDTO user){
    	LOGGER.info("Received userdata from:{}",user.getEmail() );
    	LOGGER.info("Received userdata from:{}",user.getUserId() );
    	
    	System.out.println(user.getEmail());
    	System.out.println(user.getUserId());
    	
    	saveUserToMongoDB(user);
       // LOGGER.info(String.format("\nMessage received -> %s", user));
        /*String[] parts = user.split(","); // Assuming a simple format like "SpotId: ..., EmailId: ..."
        if (parts.length == 2) {
            String userId = parts[0].replace("UserIdId: ", "").trim();
            String emailId = parts[1].replace("EmailId: ", "").trim();
            System.out.println("Hello Gaurav");
             Create a ParkingData object and save it to the database
           // Booking bookingData = new Booking();
           // bookingData.setSpotId(userId);
            //bookingData.setEmailId(emailId);

            //bookingRepository.save(bookingData);
            */
           // userDTOService.saveUserData(userId, emailId);

         //   LOGGER.info("Data saved to MongoDB.");
        //} else {
         //   LOGGER.error("Invalid message format. Message not saved.");
        //}
    	
    	
    }
    }

     

   












