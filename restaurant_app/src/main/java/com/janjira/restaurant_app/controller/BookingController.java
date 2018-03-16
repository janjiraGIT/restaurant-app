package com.janjira.restaurant_app.controller;

import java.util.List;

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

import com.janjira.restaurant_app.model.Booking;
import com.janjira.restaurant_app.service.BookingService;

@RestController
@RequestMapping("/resapp")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/booking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@GetMapping("/booking/{booking_id}")
	public Booking getBookingById(@PathVariable(value = "booking_id") Long booking_id) {
		return bookingService.getBookingById(booking_id);
	}

	// {"booking_date" : "2017-05-15", "booking_time" : "18:30", "tables_id" : 102,
	// "guess_id": 1 }
	@PostMapping("/booking")
	public Booking createNote(@Valid @RequestBody Booking booking) {
		return bookingService.createBooking(booking);

	}

	@DeleteMapping("/booking/{booking_id}")
	public ResponseEntity<?> deleteGuess(@PathVariable(value = "booking_id") Long booking_id) {
		return bookingService.deleteBooking(booking_id);
	}
}
