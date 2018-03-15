package com.janjira.restaurant_app.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.janjira.restaurant_app.exception.ResourceNotFoundException;
import com.janjira.restaurant_app.model.Guess;
import com.janjira.restaurant_app.model.Tables;
import com.janjira.restaurant_app.repository.GuessRepository;
import com.janjira.restaurant_app.repository.TablesRepository;

/**
 * 
 * @author janjiraeriksson GuessService contain the business logic and call the
 *         method in the repository layer.
 *
 */
@Service
public class GuessService {

	@Autowired
	private GuessRepository guessRepository;

	public List<Guess> getAllGuess() {
		List<Guess> guesses = new ArrayList<>();
		guessRepository.findAll().forEach(guesses::add);
		return guesses;
	}
	
	public Guess getGuessById(Long guess_id) {
		return guessRepository.findById(guess_id)
		.orElseThrow(() -> new ResourceNotFoundException("Guess", "id", guess_id));	
	}
	
	public Guess createGuess(Guess guess) {
		return guessRepository.save(guess);
		
	}
	
	public ResponseEntity<?> deleteGuess(Long guess_id) {
	    Guess guess = guessRepository.findById(guess_id)
	            		   .orElseThrow(() -> new ResourceNotFoundException("Guess", "id", guess_id));
	    	guessRepository.delete(guess);
	    return ResponseEntity.ok().build();
	}	
}
