package com.janjira.restaurant_app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "guest")
@SequenceGenerator(name = "guest", initialValue = 100)
@EntityListeners(AuditingEntityListener.class)
public class Guest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest")
	private Long guest_id;

	private String guest_name;

	private String guest_phone;

	public Long getGuest_id() {
		return guest_id;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public String getGuest_phone() {
		return guest_phone;
	}

	public void setGuest_id(Long guest_id) {
		this.guest_id = guest_id;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}

}
