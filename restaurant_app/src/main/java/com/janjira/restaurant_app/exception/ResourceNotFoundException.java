package com.janjira.restaurant_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Long noteId) {
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
	public Long getFieldValue() {
		return fieldValue;
	}
}
