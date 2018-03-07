package com.janjira.restaurant_app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janjira.restaurant_app.exception.ResourceNotFoundException;
import com.janjira.restaurant_app.model.Booking;
import com.janjira.restaurant_app.model.Guess;
import com.janjira.restaurant_app.repository.BookingRepository;
import com.janjira.restaurant_app.repository.GuessRepository;

@RestController
@RequestMapping("/resapp")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/booking")
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}
	
	@GetMapping("/booking/{booking_id}")
	public Booking getGuessById(@PathVariable(value = "booking_id") Long booking_id) {
		return bookingRepository.findById(booking_id)
				.orElseThrow(() -> new ResourceNotFoundException("Guess", "id", booking_id));
	}
	
	//{"booking_date" : "2017-05-15", "booking_time" : "18:30", "tables_id" : 102, "guess_id": 1 }
	@PostMapping("/booking")
	public Booking createNote(@Valid @RequestBody Booking booking) {
		return bookingRepository.save(booking);
		
	}
	
	@DeleteMapping("/booking/{booking_id}")
	public ResponseEntity<?> deleteGuess(@PathVariable(value = "booking_id") Long booking_id) {
	   Booking booking = bookingRepository.findById(booking_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", booking_id));
	    bookingRepository.delete(booking);
	    return ResponseEntity.ok().build();
	}	
}
