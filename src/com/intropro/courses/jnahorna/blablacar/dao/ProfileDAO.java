package com.intropro.courses.jnahorna.blablacar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;



import com.main.java.intropro.courses.jnahorna.blablacar.bl.Profile;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Ride;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.RideList;

public class ProfileDAO {
	
	private static Logger log = Logger.getLogger(RideList.class);
	private ConnectorDAO conDAO;
	private PreparedStatement addStatement;
	public ProfileDAO(){
		conDAO = ConnectorDAO.getPersister();
	    try {
			addStatement = conDAO.getConnection().prepareStatement("INSERT INTO profile (firstName, lastName, phone, email, id) VALUES (?, ?, ?, ?, ?)");
		} catch (SQLException e) {
			log.error("failed to connect")
		}
	}
	
	
	
	public void addProfileToDB(Profile p) {
		try {
			p.setId(getLastId(conDAO.getConnection()));		
			addStatement.setString(1, p.getFirstName());
			addStatement.setString(2, p.getLastName());
			addStatement.setString(3, p.getPhone());
			addStatement.setString(4, p.getEmail());
			addStatement.setInt(5, p.getId());

			int res = addStatement.executeUpdate();
  
		} catch (SQLException e) {
			Logger.getLogger(this.getClass()).error("failed to prepare statement", e);
		}
	}
	
	private int getLastId(Connection dbCon) {
        int lastId = 0;
        try {
            PreparedStatement stmt = dbCon.prepareStatement("SELECT id FROM  Profile ORDER BY id DESC LIMIT 1");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            lastId = rs.getInt("id");
        } catch (SQLException ex) {
            log.error("failed to get last id");
        }
        return lastId;
    }
	
	
}
