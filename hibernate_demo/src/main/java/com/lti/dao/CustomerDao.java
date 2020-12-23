package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
}
