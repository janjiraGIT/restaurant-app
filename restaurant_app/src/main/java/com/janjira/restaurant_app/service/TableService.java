package com.janjira.restaurant_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.janjira.restaurant_app.exception.ResourceNotFoundException;
import com.janjira.restaurant_app.model.Tables;
import com.janjira.restaurant_app.repository.TablesRepository;

@Service
public class TableService {

	@Autowired
	private TablesRepository tablesRepository;

	public List<Tables> getAllTable() {
		List<Tables> tables = new ArrayList<>();
		tablesRepository.findAll().forEach(tables::add);
		return tables;
	}
	
	public Tables getTableById(Integer id) {
		return tablesRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Table", "id", id));	
	}
	
	public Tables createTable(Tables table) {
		return tablesRepository.save(table);
		
	}
	
	public ResponseEntity<?> deleteTable(Integer id) {
	    Tables table = tablesRepository.findById(id)
	            		   .orElseThrow(() -> new ResourceNotFoundException("Table", "id", id));
	    	tablesRepository.delete(table);
	    return ResponseEntity.ok().build();
	}	
}
