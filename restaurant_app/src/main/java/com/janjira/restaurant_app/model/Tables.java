package com.janjira.restaurant_app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tables")
@SequenceGenerator(name = "tables", initialValue = 50)
@EntityListeners(AuditingEntityListener.class)
public class Tables implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tables")
	private Long table_id;

	@NotBlank
	private String table_detail;

	@NotBlank
	private Long table_limit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;

	public Long getTable_id() {
		return table_id;
	}

	public String getTable_detail() {
		return table_detail;
	}

	public Long getTable_limit() {
		return table_limit;
	}

	public void setTable_id(Long table_id) {
		this.table_id = table_id;
	}

	public void setTable_detail(String table_detail) {
		this.table_detail = table_detail;
	}

	public void setTable_limit(Long table_limit) {
		this.table_limit = table_limit;
	}
}