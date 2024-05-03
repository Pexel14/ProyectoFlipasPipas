package com.dam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

	private String driver;
	private String url;
	
	public AccesoDB() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:db/BD_Prueba.db";
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		return con;
	}
}
