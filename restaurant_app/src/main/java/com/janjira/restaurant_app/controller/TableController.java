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
import com.janjira.restaurant_app.service.TableService;

@RestController
@RequestMapping("/resapp")
public class TableController {
	
	@Autowired
	TableService tableService;
	
	//http://localhost:8080/resapp/table/
	@GetMapping("/table")
	public List<Tables> getAllTables() {
		return tableService.getAllTable();
	}
	
	//http://localhost:8080/resapp/table/3052
	@GetMapping("/table/{table_id}")
	public Tables getTableById(@PathVariable(value = "table_id") Long table_id) {
		return tableService.getTableById(table_id);
	}

	//Input in Post man : {"table_detail" : "By the windows", "table_limit" : 2}
	@PostMapping("/table")
	public Tables createTable(@Valid @RequestBody Tables table) {
		return tableService.createTable(table);	
	}
	
	//http://localhost:8080/resapp/table/3052
	@DeleteMapping("/table/{table_id}")
	public ResponseEntity<?> deleteTable(@PathVariable(value = "table_id") Long table_id) {
	   return tableService.deleteTable(table_id);
	}	
}
