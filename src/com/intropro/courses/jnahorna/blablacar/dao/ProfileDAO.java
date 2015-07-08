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
	private PreparedStatement st;
	
	
	public ProfileDAO(){
		conDAO = ConnectorDAO.getPersister();
	}
	
	
	
	public void storeProfileToDB(Profile p) {
		try {
			st = conDAO.getConnection().prepareStatement("INSERT INTO profile (first_name, last_name, email, phone_number, id) VALUES (?, ?, ?, ?, ?)");
			//p.setId(getLastId(conDAO.getConnection()));		
			st.setString(1, "Julia");
			st.setString(2, "Nahorna");
			st.setString(3, "55-333-45-666");
			st.setString(4, "julia@gmail.com");
			st.setInt(5, 17);

			int res = st.executeUpdate();
  
		} catch (SQLException e) {
			log.error("failed to prepare statement", e);
		}
	}
	
	
	
//	private int getLastId(Connection dbCon) {
//        int lastId = 0;
//        try {
//            PreparedStatement stmt = dbCon.prepareStatement("SELECT id FROM  Profile ORDER BY id DESC LIMIT 1");
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            lastId = rs.getInt("id");
//        } catch (SQLException ex) {
//            log.error("failed to get last id");
//        }
//        return lastId;
//    }
	
	
}
