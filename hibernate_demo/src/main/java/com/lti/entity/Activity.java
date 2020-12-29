package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_activity")
public class Activity {
	
	@Id
	@GeneratedValue
	private int tr_no;
	
	private LocalDateTime tx_occ;
	
	@Column(name="tx_type")
	private String tx_type;
	
	private double tx_amt;
	
	
	@ManyToOne
	@JoinColumn(name="acno")
	private Account account;


	public int getTr_no() {
		return tr_no;
	}


	public void setTr_no(int tr_no) {
		this.tr_no = tr_no;
	}


	public LocalDateTime getTx_occ() {
		return tx_occ;
	}


	public void setTx_occ(LocalDateTime tx_occ) {
		this.tx_occ = tx_occ;
	}


	public String getTx_type() {
		return tx_type;
	}


	public void setTx_type(String tx_type) {
		this.tx_type = tx_type;
	}


	public double getTx_amt() {
		return tx_amt;
	}


	public void setTx_amt(double tx_amt) {
		this.tx_amt = tx_amt;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	

}
