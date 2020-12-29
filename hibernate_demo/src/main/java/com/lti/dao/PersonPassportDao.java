package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Person;

public class PersonPassportDao extends GenericDao{
	//select p from Person p join p.passport pp where pp.expiryDate<=:date
	public List <Person> fetchByPassportExpiryDate(LocalDate date) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory ("hibernate-demo") ;
		em = emf . createEntityManager ( ) ;

		Query q = em. createQuery ("select p from Person p join p. passport pp ON p.id=pp.person_id WHER pp.expiry_date<current_date");
		q. setParameter ( "date", date) ;
		List <Person> list = q. getResultList();
		return list;
		}
		finally {
		em.close();
		emf.close();
		}

	}
}

