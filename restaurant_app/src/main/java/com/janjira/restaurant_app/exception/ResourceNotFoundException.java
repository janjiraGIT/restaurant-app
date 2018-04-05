package com.janjira.restaurant_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Integer fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer noteId) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, noteId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = noteId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Integer getFieldValue() {
		return fieldValue;
	}
}
