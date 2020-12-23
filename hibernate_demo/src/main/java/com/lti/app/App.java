package com.lti.app;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		Customer c=new Customer();
		c.setName("Tanay");
		c.setEmail("tanay@gmail.com");
		c.setDateOfBirth((LocalDate.of(1998,10,25)));
	
		
		CustomerDao dao=new CustomerDao();
		dao.store(c);

	}

}
