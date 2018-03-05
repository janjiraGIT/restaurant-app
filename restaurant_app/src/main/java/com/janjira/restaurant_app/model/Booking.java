package com.janjira.restaurant_app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="booking")
@SequenceGenerator(name="booking", initialValue=1001)
@EntityListeners(AuditingEntityListener.class)
public class Booking implements Serializable{ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="booking")
	private Long booking_id;
	
	@NotBlank
	@Temporal(TemporalType.DATE)
	private java.util.Date booking_date ;
	
	@NotBlank
	@Temporal(TemporalType.TIME)
	private java.util.Date booking_time ;
	
	@NotBlank
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "booking")
	private List<Tables> tables = new ArrayList<Tables>();
	
	@NotBlank
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guess_id")
	private Guess guess;
	
	public Booking() {
		
	}

	public Booking(Date booking_date, Date booking_time, @NotBlank @NotBlank List<Tables> tables, @NotBlank Guess guess) {
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.tables = tables;
		this.guess = guess;
	}

	public Guess getGuess() {
		return guess;
	}

	public void setGuess(Guess guess) {
		this.guess = guess;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public java.util.Date getBooking_date() {
		return booking_date;
	}

	public java.util.Date getBooking_time() {
		return booking_time;
	}

	public @NotBlank List<Tables> getTables() {
		return tables;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public void setBooking_date(java.util.Date booking_date) {
		this.booking_date = booking_date;
	}

	public void setBooking_time(java.util.Date booking_time) {
		this.booking_time = booking_time;
	}

	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}
}

