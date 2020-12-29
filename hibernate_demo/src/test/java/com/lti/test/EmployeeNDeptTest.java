package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dao.GenericDaoN;
import com.lti.entity.Department;
import com.lti.entity.EmployeeN;

public class EmployeeNDeptTest {
	
	@Test
	public void addDepartment() {
		Department dept = new Department();
		dept.setLocation("Mumbai");
		dept.setName("dept1");

		GenericDao dao = new GenericDao();
		dao.save(dept);
	}

	@Test
	public void addEmployeetoDepartment() {
		GenericDao dao = new GenericDao();
		Department dept = (Department) dao.fetch(Department.class, 47);

		EmployeeN emp = new EmployeeN();
		emp.setName("Tanmay");
		emp.setDateOfJoining(LocalDate.of(2020, 10, 28));
		emp.setSalary(15000);
		emp.setDept(dept);

		dao.save(emp);
	}



	@Test
	public void addEmployeeandDepartment() {
		Department dept = new Department();
		dept.setLocation("Mumbai");
		dept.setName("Ramg");

		EmployeeN emp1 = new EmployeeN();
		emp1.setName("Amit");
		emp1.setDateOfJoining(LocalDate.of(2020, 5, 21));
		emp1.setSalary(20000);
		emp1.setDept(dept);

		EmployeeN emp2 = new EmployeeN();
		emp2.setName("Shambhavi");
		emp2.setDateOfJoining(LocalDate.of(2019, 4, 14));
		emp2.setSalary(10000);
		emp2.setDept(dept);

		List<EmployeeN> employees = new ArrayList<EmployeeN>();
		employees.add(emp1);
		employees.add(emp2);

		dept.setEmployees(employees);

		GenericDao dao = new GenericDao();
		dao.save(dept);
	}
}



