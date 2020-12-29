package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_prod")
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	

}
