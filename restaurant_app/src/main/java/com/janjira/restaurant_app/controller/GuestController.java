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
import com.janjira.restaurant_app.model.Guest;
import com.janjira.restaurant_app.service.GuestService;

@RestController
@RequestMapping("/resapp")
public class GuestController {
	
	@Autowired
	GuestService guestService;
	
	@GetMapping("/guest")
	public List<Guest> getAllGuests() {
		return guestService.getAllGuests() ;
	}
	
	@GetMapping("/guest/{guest_id}")
	public Guest getGuestById(@PathVariable(value = "guest_id") Integer guest_id) {
		return guestService.getGuestById(guest_id);
	}
	
	@PostMapping("/guest")
	public Guest createGuest(@Valid @RequestBody Guest guest) {
		return guestService.createGuest(guest);
		
	}
	
	@DeleteMapping("/guest/{guest_id}")
	public ResponseEntity<?> deleteGuest(@PathVariable(value = "guest_id") Integer guest_id) {
	    return guestService.deleteGuest(guest_id);
	}	
}
