package com.ruipeng.student.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.ruipeng.student.factory.StudentFactory;

public class ConnectionManager {
	
	public Connection getConnection(){
		Connection con = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(StudentFactory.class.getClassLoader().getResource("Db_infor.properties").getPath()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = prop.getProperty("dbUrl");
		String user = prop.getProperty("dbUserName");
		String password = prop.getProperty("dbPassword");
		try {
			Class.forName(prop.getProperty("dbClassName"));
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}