package com.janjira.restaurant_app.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="guess")
@SequenceGenerator(name="guess", initialValue=100)
@EntityListeners(AuditingEntityListener.class)
public class Guess implements Serializable{ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="guess")
	private Long guess_id;
	
	@NotBlank
	private String guess_name;
	
	@NotBlank
	private String guess_phone;

	public Long getGuess_id() {
		return guess_id;
	}

	public String getGuess_name() {
		return guess_name;
	}

	public String getGuess_phone() {
		return guess_phone;
	}

	public void setGuess_id(Long guess_id) {
		this.guess_id = guess_id;
	}

	public void setGuess_name(String guess_name) {
		this.guess_name = guess_name;
	}

	public void setGuess_phone(String guess_phone) {
		this.guess_phone = guess_phone;
	}
}

