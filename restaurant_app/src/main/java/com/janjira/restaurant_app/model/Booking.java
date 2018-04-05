package com.janjira.restaurant_app.model;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="booking")
@EntityListeners(AuditingEntityListener.class)
public class Booking implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Integer id;
	
    @Basic 
	private java.time.LocalDate date ;
		
    @Basic
	private java.time.LocalTime time ;
    
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private Guest guest;
    
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "table_id")
   	private Tables tables;
	
	
	public Booking() {
		
	}


	public Integer getId() {
		return id;
	}


	public java.time.LocalDate getDate() {
		return date;
	}


	public java.time.LocalTime getTime() {
		return time;
	}


	public Guest getGuest() {
		return guest;
	}


	public Tables getTables() {
		return tables;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setDate(java.time.LocalDate date) {
		this.date = date;
	}


	public void setTime(java.time.LocalTime time) {
		this.time = time;
	}


	public void setGuest(Guest guest) {
		this.guest = guest;
	}


	public void setTables(Tables tables) {
		this.tables = tables;
	}

	
}

