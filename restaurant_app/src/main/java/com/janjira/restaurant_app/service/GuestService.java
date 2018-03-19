package com.janjira.restaurant_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.janjira.restaurant_app.exception.ResourceNotFoundException;
import com.janjira.restaurant_app.model.Guest;
import com.janjira.restaurant_app.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public List<Guest> getAllGuests() {
		List<Guest> guests = new ArrayList<>();
		guestRepository.findAll().forEach(guests::add);
		return guests;
	}
	
	public Guest getGuestById(Long guest_id) {
		return guestRepository.findById(guest_id)
		.orElseThrow(() -> new ResourceNotFoundException("Guest", "id", guest_id));	
	}
	
	public Guest createGuest(Guest guest) {
		return guestRepository.save(guest);
		
	}
	
	public ResponseEntity<?> deleteGuest(Long guest_id) {
	    Guest guest = guestRepository.findById(guest_id)
	            		   .orElseThrow(() -> new ResourceNotFoundException("Guest", "id", guest_id));
	    	guestRepository.delete(guest);
	    return ResponseEntity.ok().build();
	}	
}
