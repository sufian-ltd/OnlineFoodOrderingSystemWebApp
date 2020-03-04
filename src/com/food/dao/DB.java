package com.food.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/online_food_ordering_system", "root", "");

		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
