package com.java.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DisplayProduct {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1234", "root","root");
			Statement statement=con.createStatement();
			
			List<Product> list=new LinkedList<Product>();
			
			
			ResultSet set=statement.executeQuery("SELECT * FROM `1234`.product");
			while(set.next())
				
			{
				Product product=new Product();
				product.setName(set.getString(2));
				product.setCost(set.getFloat(3));
				list.add(product);
			}
			
			for(Product product:list)
			{
				System.out.println(product.getName()+"  "+product.getCost());
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}

	}

}
