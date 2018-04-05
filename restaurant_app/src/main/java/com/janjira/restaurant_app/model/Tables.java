package com.janjira.restaurant_app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tables")
@EntityListeners(AuditingEntityListener.class)
public class Tables implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_id")
	private Integer id;
	private String detail;
	private String maxPerson;

	public Tables() {

	}

	public String getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(String maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Integer getId() {
		return id;
	}

	public String getDetail() {
		return detail;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


}