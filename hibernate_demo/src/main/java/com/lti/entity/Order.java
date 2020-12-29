package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tbl_order")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	private double total;
	private LocalDate orderDate;
	
	@OneToMany(mappedBy="order")
	private List<LineItem> lineItems;

}
