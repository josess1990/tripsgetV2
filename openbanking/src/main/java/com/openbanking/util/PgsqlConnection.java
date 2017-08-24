package com.openbanking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import org.postgresql.Driver;

public class PgsqlConnection {


	public PgsqlConnection() {
		try {
			Connection c = null;
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://ec2-35-176-248-162.eu-west-2.compute.amazonaws.com:5432/open_banking",
					"josess1990", "Sharpshooter1");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
	
	

}
