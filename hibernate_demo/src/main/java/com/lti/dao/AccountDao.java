package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Activity;

public class AccountDao extends GenericDao{
	
	public List<Activity> fetchMiniStatement(int acno) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
			
			Query q=em.createNamedQuery("select a from Activity where a.account.acno= :acno order by a.dateAndTime desc");
			q.setParameter("acno", acno);
			q.setMaxResults(5);//Will use rownum in case of oracle
			List<Activity> list=q.getResultList();
			return list;
			
			
		} finally {
			em.close();
			emf.close();
		}
		
		
		
	}
	public List<Object[]> fetchAccountDetails(int acno,LocalDate transactionDate){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence. createEntityManagerFactory("hibernate-demo");
		em = emf .createEntityManager();
		Query q = em.createQuery("select acc.name, tx.amount, tx.type from Account acc join acc.activities tx"+"where acc.acno= :acno and tx.dateAndTime= :date");
		q.setParameter("acno",acno);
		q.setParameter("date", transactionDate);

		List <Object[]> list = q.getResultList();
		return list;
		}
		finally { 
		em.close();
		emf.close ();
		}
		
	}

}

