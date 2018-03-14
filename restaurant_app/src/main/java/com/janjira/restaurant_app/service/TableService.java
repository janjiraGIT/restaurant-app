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
import com.janjira.restaurant_app.model.Tables;
import com.janjira.restaurant_app.repository.TablesRepository;

/**
 * 
 * @author janjiraeriksson TableService contain the business logic and call the
 *         method in the repository layer.
 *
 */
@Service
public class TableService {

	@Autowired
	private TablesRepository tablesRepository;

	public List<Tables> getAllTable() {
		List<Tables> tables = new ArrayList<>();
		tablesRepository.findAll().forEach(tables::add);
		return tables;
	}
	
	public Tables getTableById(Long table_id) {
		return tablesRepository.findById(table_id)
		.orElseThrow(() -> new ResourceNotFoundException("Table", "id", table_id));	
	}
	
	public Tables createTable(Tables table) {
		return tablesRepository.save(table);
		
	}
	
	public ResponseEntity<?> deleteTable(Long table_id) {
	    Tables table = tablesRepository.findById(table_id)
	            		   .orElseThrow(() -> new ResourceNotFoundException("Table", "id", table_id));
	    	tablesRepository.delete(table);
	    return ResponseEntity.ok().build();
	}	
}
