package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.entity.Employee;

public class EmployeeAddressDao {

	public void store(Employee employee) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
	
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(employee);
		tx.commit();
		
		em.close();
		emf.close();
	}
	
	
	public void store(Address address) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
	
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(address);
		tx.commit();
		
		em.close();
		emf.close();
	
	
	}

	public Employee fetch(int id) {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("hibernate-demo");
	EntityManager em=emf.createEntityManager();
	
	//find method generate SELECT ___ WHERE pk=?
	Employee emp=em.find(Employee.class,id);
	
	
	em.close();
	emf.close();
	
	
	return emp;
}
	public void update(Employee employee) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(employee);//merge method generates Update query
		tx.commit();
		
		em.close();
		emf.close();
	}
}