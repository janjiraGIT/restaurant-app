package com.janjira.restaurant_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.janjira.restaurant_app.exception.ResourceNotFoundException;
import com.janjira.restaurant_app.model.Booking;
import com.janjira.restaurant_app.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBooking() {
		List<Booking> booking = new ArrayList<>();
		bookingRepository.findAll().forEach(booking::add);
		return booking;
	}
	
	public Booking getBookingById(Long booking_id) {
		return bookingRepository.findById(booking_id)
		.orElseThrow(() -> new ResourceNotFoundException("Booking", "id", booking_id));	
	}
	
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
		
	}
	
	public ResponseEntity<?> deleteBooking(Long booking_id) {
	    Booking booking = bookingRepository.findById(booking_id)
	            		   .orElseThrow(() -> new ResourceNotFoundException("Guess", "id", booking_id));
	    	bookingRepository.delete(booking);
	    return ResponseEntity.ok().build();
	}	
	
	
	//TODO :
	// https://stackoverflow.com/questions/41772855/in-spring-boot-jpa-how-to-properly-post-an-object-whose-entity-representation-h

}
