package com.janjira.restaurant_app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "booking_id")
	private Long booking_id;
	
    @Basic 
	private java.time.LocalDate booking_date ;
		
    @Basic
	private java.time.LocalTime booking_time ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "table_id", referencedColumnName = "table_id")
	private Tables tables;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "guess_id", referencedColumnName = "guess_id" )
	private Guess guess;
	
	public Guess getGuess() {
		return guess;
	}

	public void setGuess(Guess guess) {
		this.guess = guess;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public LocalTime getBooking_time() {
		return booking_time;
	}

	public Tables getTables() {
		return tables;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public void setBooking_time(LocalTime booking_time) {
		this.booking_time = booking_time;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}
}

