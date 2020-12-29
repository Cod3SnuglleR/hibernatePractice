package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Employee;
import com.lti.entity.Passport;
import com.lti.entity.Person;

public class PersonPassportTest {
	
	@Test
	public void addingPerson() {
		Person per = new Person();
		per.setName("Ajay");
		per.setEmail("Amit19@gmail.com");
	
		GenericDao dao= new GenericDao();
		dao.save(per);
		
	}
	@Test
	public void issuingPassportToAPerson() {
		GenericDao dao=new GenericDao();
		Person per =(Person) dao.fetch(Person.class,32);
		Passport passport=new Passport();
		passport.setIssueDate(LocalDate.of(2020,10,10));
		passport.setExpiryDate(LocalDate.of(2024,10,10));
		passport.setAuthority("Government Of India");
		passport.setPerson(per);
		dao.save(passport);
	}
	@Test
	public void addPersonAlongWithPassport() {
		GenericDao dao=new GenericDao();
		
		Person per =new Person();
		per.setName("Ritesh");
		per.setEmail("ritesh@gmail.com");
		
		Passport passport=new Passport();
		passport.setIssueDate(LocalDate.of(2015, 11, 14));
		passport.setExpiryDate(LocalDate.of(2027, 9, 04));
		passport.setAuthority("Government of India");
		
		per.setPassport(passport);
		passport.setPerson(per);
		dao.save(per);//requires cascade setting
		
		
	}

}
