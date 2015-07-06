package com.intropro.courses.jnahorna.blablacar.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.main.java.intropro.courses.jnahorna.blablacar.bl.BlaCarDomainObjExistsExc;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Profile;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Ride;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.RideList;

public class RideDAO {

	private static Logger log = Logger.getLogger(RideList.class);

	private ConnectorDAO conDAO;
	private ProfileDAO pDAO;

	public RideDAO() {
		conDAO = ConnectorDAO.getPersister();
		pDAO = new ProfileDAO();
	}

	private void addRideToDB(Ride r) {
		try {
			pDAO.addProfileToDB(r.getOwner());
			PreparedStatement preparedStatement = conDAO.getConnection().prepareStatement("INSERT INTO rides (start, finish, dateTime, owner, status) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, r.getStart());
			preparedStatement.setString(2, r.getFinish());
			preparedStatement.setDate(3, new java.sql.Date(r.getDateTime().getTime()));
			preparedStatement.setInt(4, r.getOwner().getId());
			preparedStatement.setString(5, r.getStatus());

			int res = preparedStatement.executeUpdate();
  
		} catch (SQLException e) {
			Logger.getLogger(this.getClass()).error("failed to prepare statement", e);
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
