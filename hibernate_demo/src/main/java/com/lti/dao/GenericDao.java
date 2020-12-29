package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Employee;

public class GenericDao {//CommonDao,BaseDao,SabkaDao,ApnaDao,
	
	public Object save (Object obj) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			try {
				emf = Persistence.createEntityManagerFactory("hibernate-demo");
				em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.merge(obj); // it can also be used for insert and update
				tx.commit();
				return obj;

			} 
			finally {
				em.close();
				emf.close();
			}
		}

	public Object fetch(Class clazz,Object pk) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		Object obj = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			em = emf.createEntityManager();
			obj =em.find(clazz,pk);
			return obj;
			
			
		} finally {
			em.close();
			emf.close();
		}
		
		
	}

		public List<Object> fetchAll() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();

			Query q = (Query) em.createQuery("Select a from Department as a ");
			List<Object> list = ((javax.persistence.Query) q).getResultList();

			em.close();
			emf.close();

			return list;
		}
}
	

