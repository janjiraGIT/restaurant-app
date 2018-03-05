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
import com.janjira.restaurant_app.model.Guess;
import com.janjira.restaurant_app.repository.GuessRepository;

@RestController
@RequestMapping("/resapp")
public class GuessController {
	
	@Autowired
	GuessRepository guessRepository;
	
	@GetMapping("/guess")
	public List<Guess> getAllGuess() {
		return guessRepository.findAll();
	}
	
	@GetMapping("/guess/{guess_id}")
	public Guess getGuessById(@PathVariable(value = "guess_id") Long guess_id) {
		return guessRepository.findById(guess_id)
				.orElseThrow(() -> new ResourceNotFoundException("Guess", "id", guess_id));
	}
	
	@PostMapping("/guess")
	public Guess createNote(@Valid @RequestBody Guess guess) {
		return guessRepository.save(guess);
		
	}
	
	@DeleteMapping("/guess/{guess_id}")
	public ResponseEntity<?> deleteGuess(@PathVariable(value = "guess_id") Long guess_id) {
	    Guess guess = guessRepository.findById(guess_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Guess", "id", guess_id));
	    guessRepository.delete(guess);
	    return ResponseEntity.ok().build();
	}	
}
