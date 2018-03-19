package com.janjira.restaurant_app.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="booking")
@SequenceGenerator(name="booking", initialValue=1001)
@EntityListeners(AuditingEntityListener.class)
public class Booking implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="booking")
	@Column(name = "booking_id")
	private Long booking_id;
	
    @Basic 
	private java.time.LocalDate booking_date ;
		
    @Basic
	private java.time.LocalTime booking_time ;
	
	private Long guest_id; 
	
	private Long table_id;

	public Long getBooking_id() {
		return booking_id;
	}

	public java.time.LocalDate getBooking_date() {
		return booking_date;
	}

	public java.time.LocalTime getBooking_time() {
		return booking_time;
	}

	public Long getGuest_id() {
		return guest_id;
	}

	public Long getTable_id() {
		return table_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public void setBooking_date(java.time.LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public void setBooking_time(java.time.LocalTime booking_time) {
		this.booking_time = booking_time;
	}

	public void setGuest_id(Long guest_id) {
		this.guest_id = guest_id;
	}

	public void setTable_id(Long table_id) {
		this.table_id = table_id;
	}
}

