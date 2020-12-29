package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_dept")
public class Department {
	
	@Id
	@GeneratedValue
	private int deptNo;
	
	
	private String name;
	private String location;
	
	@OneToMany(mappedBy ="department",cascade=CascadeType.MERGE)
	private List<EmployeeN>employees;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EmployeeN> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeN> employees) {
		this.employees = employees;
	}
	

}
