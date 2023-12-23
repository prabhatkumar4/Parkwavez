package com.example.parkingspacebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspacebooking.Model.Booking;
import com.example.parkingspacebooking.Service.BookingServiceImpl;

import org.springframework.kafka.core.KafkaTemplate;
import com.kafkaProducer.BookingDTO;

@RestController
@RequestMapping("/Booking")
@CrossOrigin()
public class BookingController {
	
	 @Autowired
	    private BookingServiceImpl service;
	 
	 //Navneet Code start
	 @Autowired
	 private KafkaTemplate<String, BookingDTO> kafkaTemplate3;
	 BookingDTO bookingDTO = new BookingDTO();
	 //Navneet Code ends
	 
	 @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Booking createBooking(@RequestBody Booking booking){
//		 System.out.println(booking.getCheck_In());
		 System.out.println(booking);
		 
		    //Navneet Code starts
	    	bookingDTO.setUserId(booking.getUserId());
	    	bookingDTO.setAmount(booking.getAmount());
	    	bookingDTO.setBooking_date(booking.getBooking_date());
	    	bookingDTO.setBookingId(booking.getBookingId());
	    	bookingDTO.setCheck_In(booking.getCheck_In());
	    	bookingDTO.setCheck_Out(booking.getCheck_Out());
	    	bookingDTO.setEmailId(booking.getEmailId());
	    	bookingDTO.setSpotId(booking.getSpotId());
	    	bookingDTO.setStatus(booking.getStatus());
	    	kafkaTemplate3.send("bookingNotification", bookingDTO);
	    	//Navneet Code Ends
		 
	        return service.addBooking(booking);
	    }
	 
	 @PutMapping
	    public Booking modifyBooking(@RequestBody Booking booking){
	        return service.updateBooking(booking);
	    }
	 
	 @DeleteMapping("/{BookingId}")
	    public String deleteBooking(@PathVariable String BookingId){
	        return service.cancleBooking(BookingId);
	        
	       
	    }
	 
	 @GetMapping("/{BookingId}")
	    public Booking getBooking(@PathVariable String BookingId){
	        return service.getBookingById(BookingId);
	 }
	 
	 @GetMapping("/User/{UserId}")
	   public List<Booking> getBookingByUserId(@PathVariable String UserId){
	       return  service.getBookingByUserId(UserId);
		// System.out.println("Working");
	 //return null;
	 }
	 
	 @GetMapping("/Status/{Status}")
	   public List<Booking> getBookingByStatus(@PathVariable String Status){
	       return  service.getBookingByStatus(Status);
	 }
	 
	 
	 @GetMapping
	    public List<Booking> getBooking() {
	        return service.getAllBooking();
	    }



}
