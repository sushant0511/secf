package com.java.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddProduct {

	public static void main(String[] args) {
		
		int id;
		String name;
		float cost;
		String brand;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter you id ,name, cost and barnd");
		id=scanner.nextInt();
		name=scanner.next();
		cost=scanner.nextFloat();
		brand=scanner.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1234", "root","root");
			Statement statement=con.createStatement();
			String query="insert into product VALUES('"+id+"','"+name+"','"+cost+"','"+brand+"') ";
			statement.executeUpdate(query);
			System.out.println("Data inserted successfully");
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}

		

	}

}
