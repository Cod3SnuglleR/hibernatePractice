package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;


//Data Access Objects
public class CustomerDao {

	public void store(Customer customer) {
		//Step 1.Create EntittyManagerFactory object
		//During this step,META-INF/persistence.xml file will be read
		//what we are passing in double quotes below is <persistent-unit name="?????"....>
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		//Step 2.Create EntityManager object
		//This step is similar to creating a Statement object when using JDBC API
		EntityManager em=emf.createEntityManager();
		//Step 3.Start/Participate in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		//Now we can perform any SQL operation with the help of EntityManager
		em.persist(customer);//persist method generates INSERT query
		tx.commit();
		//should be in finally block actually
		em.close();
		emf.close();
	}
	public void update(Customer customer) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(customer);//merge method generates Update query
		tx.commit();
		
		em.close();
		emf.close();
	}
	public Customer fetch(int id) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		
		//find method generate SELECT ___ WHERE pk=?
		Customer cust=em.find(Customer.class,id);
		
		
		em.close();
		emf.close();
		
		
		return cust;
	}
	public List<Customer> fetchAll(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		//JPQL
		Query q=em.createNamedQuery("select c from customer as c");
		List<Customer> list =q.getResultList();
		
		
		em.close();
		emf.close();
		
		
		return list;
	}
	public List<Customer> fetchByEmailOf(String domainName){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		//SQL->select * from tbl_cust where email_addr like '%gmail%';
		Query q=em.createQuery("select c from Customer as c where c.email like:em");//placeholder
		q.setParameter("em","%"+domainName+ "%");
		List<Customer> list =q.getResultList();
		
		
		em.close();
		emf.close();
		
		return list;
	}
	public List<Customer> fetchByBirthYear(int year){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		//SQL->select * from tbl_cust where tbl_cust where extract(Year from date_of_birth)=1998
		Query q=em.createQuery("select c from Customer as c where year(c.dateOfBirth)= : yr");//placeholder
		q.setParameter("yr",year);
		List<Customer> list =q.getResultList();
		
		
		em.close();
		emf.close();
		
		return list;
	}
}
