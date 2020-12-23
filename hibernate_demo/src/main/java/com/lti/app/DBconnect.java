package com.lti.app;

import java.sql.DriverManager;

public class DBconnect {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","system","Ging3RBR34D");
		System.out.println("Connected");

	}

}
