package com.lti.app;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {

	public static void main(String[] args) {
		/*Customer c=new Customer();
		c.setName("Subodh");
		c.setEmail("subodh@gmail.com");
		c.setDateOfBirth((LocalDate.of(1998,7,5)));
	
		
		CustomerDao dao=new CustomerDao();
		dao.store(c);*/
		/*CustomerDao dao =new CustomerDao();
		Customer c =dao.fetch(1);//please check the id in the db before you run
		System.out.println(c.getName()+","+c.getEmail()+","+c.getDateOfBirth());*/
		
		/*CustomerDao dao=new CustomerDao();
		List<Customer> list =dao.fetchAll();
		//ToDO:write the for loop for the above list 
		for(Customer c: list)
			System.out.println(c.getId()+","+c.getName()+","+c.getEmail()+","+c.getDateOfBirth());*/

		/*CustomerDao dao=new CustomerDao();
		List<Customer> list =dao.fetchByEmailOf("yahoo.com");
		//ToDO:write the for loop for the above list 
		for(Customer c: list)
			System.out.println(c.getId()+","+c.getEmail());*/
		/*CustomerDao dao=new CustomerDao();
		List<Customer> list =dao.fetchByBirthYear(1995);
		//ToDO:write the for loop for the above list 
		for(Customer c: list)
			System.out.println(c.getId()+","+c.getDateOfBirth());*/
		CustomerDao dao = new CustomerDao();
		Customer c= dao.fetch(1);
		c.setEmail("tanmaytripathi@gmail.com");
		dao.update(c);

	}

}
