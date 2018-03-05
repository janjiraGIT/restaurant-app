package com.janjira.restaurant_app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janjira.restaurant_app.model.Guess;
import com.janjira.restaurant_app.repository.GuessRepository;

@RestController
@RequestMapping("/api")
public class GuessController {
	
	@Autowired
	GuessRepository guessRepository;
	
	@GetMapping("/guess")
	public List<Guess> getAllGuess() {
		return guessRepository.findAll();
	}
	
	@PostMapping("/guess")
	public Guess createNote(@Valid @RequestBody Guess guess) {
		return guessRepository.save(guess);
		
	}
}
