package com.intropro.courses.jnahorna.blablacar.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Persister {

	private static Persister persister = null;
	private Connection con = null;
	
	public static Persister getPersister(){
		if (persister == null){
			synchronized(Persister.class){
				if (persister == null){
					persister = new Persister();
				}
			}
		}
		return persister;
	}
	
	
	private Persister(){
		init();
	}
	
	private void init(){
		
		ResourceBundle resource = ResourceBundle.getBundle("connection");
		String host = resource.getString("host");
		//TODO read configuration files to acquire proper connection settings
		try {
		con = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/learndb", "jdbc", "jdbc");
		} catch (SQLException ex) {
			//TODO add logger here
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	
}
