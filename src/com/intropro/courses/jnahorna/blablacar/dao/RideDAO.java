package com.intropro.courses.jnahorna.blablacar.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.main.java.intropro.courses.jnahorna.blablacar.bl.BlaCarDomainObjExistsExc;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Profile;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Ride;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.RideList;

public class RideDAO {

	private static Logger log = Logger.getLogger(RideList.class);

	private ConnectorDAO connectorDao;
	private ProfileDAO profileDao;

	public RideDAO() {
		connectorDao = ConnectorDAO.getPersister();
		profileDao = new ProfileDAO();
	}

	public void storeRideToDB(Ride r) {
		try {
			//profileDao.storeProfileToDB(r.getOwner());
			PreparedStatement st = connectorDao.getConnection().prepareStatement("INSERT INTO rides (start, finish status) VALUES (?, ?, ?)");
			st.setString(1, "18:00");
			st.setString(2, "18:05");
			//st.setDate(3, new java.sql.Date(r.getDateTime().getTime()));
			//st.setInt(4, r.getOwner().getId());
			st.setString(5, "Active");

			int res = st.executeUpdate();
  
		} catch (SQLException e) {
			log.error("failed to prepare statement", e);
		}
	}

//	public Ride createRide(String start, String finish, Date dateTime,Profile owner) {
//		Ride ride = null;
//		try {
//			if (search(start, finish, dateTime, owner).size() != 0) {
//				throw new BlaCarDomainObjExistsExc("Failed to create new ride: Ride already exist");
//			}
//			ride = Ride.createRide(start, finish, dateTime, owner);
//			// rides.add(ride);
//			addRideToDB(ride);
//		} catch (BlaCarDomainObjExistsExc ex) {
//			log.debug("Cannot create ride: " + ex.getMessage());
//			log.error("Cannot create ride: " + ex.getMessage());
//		}
//		return ride;	
//}
}
