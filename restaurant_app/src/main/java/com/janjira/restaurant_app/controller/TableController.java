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
import com.janjira.restaurant_app.model.Tables;
import com.janjira.restaurant_app.repository.GuessRepository;
import com.janjira.restaurant_app.repository.TablesRepository;

@RestController
@RequestMapping("/resapp")
public class TableController {
	
	@Autowired
	TablesRepository tablesRepository;
	
	@GetMapping("/table")
	public List<Tables> getAllGuess() {
		return tablesRepository.findAll();
	}
	
	@GetMapping("/table/{table_id}")
	public Tables getGuessById(@PathVariable(value = "table_id") Long table_id) {
		return tablesRepository.findById(table_id)
				.orElseThrow(() -> new ResourceNotFoundException("Guess", "id", table_id));
	}
	//Input in Post man : {"table_detail" : "By the windows", "table_limit" : 2}
	@PostMapping("/table")
	public Tables createNote(@Valid @RequestBody Tables table) {
		return tablesRepository.save(table);
		
	}
	
	@DeleteMapping("/table/{table_id}")
	public ResponseEntity<?> deleteGuess(@PathVariable(value = "table_id") Long table_id) {
	    Tables table = tablesRepository.findById(table_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Table", "id", table_id));
	    tablesRepository.delete(table);
	    return ResponseEntity.ok().build();
	}	
}
