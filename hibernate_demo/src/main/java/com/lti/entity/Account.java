package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_accnt")
public class Account {
	
	@Id
	@GeneratedValue
	private int acnt_no;
	private String cus_name;
	@Column(name="acc_type")
	private String acnt_typ;
	private double balance;
	
	@OneToMany(mappedBy="account")
	private List<Activity> activities;

	public int getAcnt_no() {
		return acnt_no;
	}

	public void setAcnt_no(int acnt_no) {
		this.acnt_no = acnt_no;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getAcnt_typ() {
		return acnt_typ;
	}

	public void setAcnt_typ(String acnt_typ) {
		this.acnt_typ = acnt_typ;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
		
	
	

}
