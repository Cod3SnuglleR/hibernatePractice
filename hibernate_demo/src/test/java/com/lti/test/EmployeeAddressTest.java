package com.lti.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.lti.dao.EmployeeAddressDao;
import com.lti.entity.Address;
import com.lti.entity.Employee;

public class EmployeeAddressTest {
	
	@Test
	public void addNewEmployee() {
		Employee emp = new Employee();
		emp.setName("Amit");
		emp.setDateOfJoining(LocalDate.of(2020, 10, 10));
		emp.setSalary(30000);
		EmployeeAddressDao dao= new EmployeeAddressDao();
		dao.store(emp);
		//asserts missing right now--
		//without which we can't ascertain whether code is functional or not
		
	}
	
	@Test
	public void addAddressForAnExitingEmployee() {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		Employee emp =dao.fetch(10);
		
		Address addr =new Address();
		addr.setLandmark("Chandani Chowk");
		addr.setCity("Delhi");
		addr.setPincode(110001);
		
		emp.setAddress(addr);//setting the relationship
		
		dao.store(addr);
		dao.update(emp);
	
	}
	
	@Test
	public void addANewEmployeeAlongWithAddress() {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		Employee emp = new Employee();
		emp.setName("Ojas");
		emp.setDateOfJoining(LocalDate.of(2020, 10, 10));
		emp.setSalary(30000);
		
		Address addr =new Address();
		addr.setLandmark("Colaba");
		addr.setCity("Mumbai");
		addr.setPincode(44001);
		emp.setAddress(addr);
		dao.store(addr);
		dao.store(emp);
		
	}
	public void addAnEmployeeAlongWithAddressUsingCascade() {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		Employee emp = new Employee();
		emp.setName("Ruchita");
		emp.setDateOfJoining(LocalDate.of(2020, 10, 10));
		emp.setSalary(30000);
		
		Address addr =new Address();
		addr.setLandmark("Panvel");
		addr.setCity("Mumbai");
		addr.setPincode(26005);
		
		
		emp.setAddress(addr);
		//when employee data is saved then data gets saved tooo
		dao.store(emp);
}
	
		public List<Employee> fetchByCity(String city){
			EntityManagerFactory emf =Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em =emf.createEntityManager();
			//Sql
			//select e.*tbl_emp eINNER JOIN tbl_addr a ON e.addr_id
			//where a.city ='Mumbai'
			Query q = em.createQuery("select e from Employee e join e.address a where a.city = :ct");
			q.setParameter("ct",city);
			List<Employee> list =q.getResultList();
			
			em.close();
			emf.close();
			
			return list;
	
		}
}

