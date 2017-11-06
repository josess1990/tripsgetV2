package com.openbanking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class PgsqlConnection {

	private Connection connection;


	public PgsqlConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-35-176-248-162.eu-west-2.compute.amazonaws.com:5432/open_banking",
					"josess1990", "Sharpshooter1");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
	
	
	public void executeStatement(String args) throws SQLException {
		// create a Statement from the connection
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO public.atms(extl_id, bank_name) VALUES (4,'HSBC');");
		pstmt.execute();
	
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to close connection");
		}
	}
	

}
