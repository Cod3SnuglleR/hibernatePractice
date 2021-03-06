package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
@Entity
@Table(name ="tbl_cust")
public class Customer {
	@Id//pk
	@GeneratedValue//auto generate the pk
	@Column(name="cust_id")
	private int id;
	@Column(name="cust_name")
	private String name;
	@Column(name="email_addr",unique =true)
	private String email;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth1(LocalDate i) {
		this.dateOfBirth = i;
	}
	public void setDateOfBirth(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}

}
