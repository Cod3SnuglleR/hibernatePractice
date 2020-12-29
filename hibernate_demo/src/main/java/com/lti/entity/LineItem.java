package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_lineitem")
public class LineItem {
	@Id
	@GeneratedValue
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private int id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private Order order;
	

}
