package com.intropro.courses.jnahorna.blablacar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class ConnectorDAO {

	private static ConnectorDAO persister = null;
	private Connection con = null;
	
	public static ConnectorDAO getPersister(){
		if (persister == null){
			synchronized(ConnectorDAO.class){
				if (persister == null){
					persister = new ConnectorDAO();
				}
			}
		}
		return persister;
	}
	
	
	private ConnectorDAO(){
		init();
	}
	
	private void init(){
		
//		ResourceBundle resource = ResourceBundle.getBundle("connection");
//		String host = resource.getString("host");
//		String port = resource.getString("port");
//		String database = resource.getString("database");
//		String dbType = resource.getString("dbType");
		try {
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learndb", "jdbc", "jdbc");
		System.out.println("DONE!");
		} catch (SQLException ex) {
			Logger.getLogger(this.getClass()).error("failed to connect", ex);
			
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	
}
