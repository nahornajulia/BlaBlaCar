package com.intropro.courses.jnahorna.blablacar;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.intropro.courses.jnahorna.blablacar.persist.Persister;

public class RideList {
	
	private static Logger LOG =  Logger.getLogger(RideList.class);

	private Persister pers;
	
	//private List<Ride> rides = new ArrayList<Ride>();

	public RideList(){
		pers = Persister.getPersister(); 
	}
	private void addRideToDB(Ride r){
		try {
			PreparedStatement preparedStatement = pers.getConnection().prepareStatement("INSERT INTO rides (start, finish) VALUES (?, ?)");
		    preparedStatement.setString(1, r.getStart());
		    preparedStatement.setString(2, r.getFinish());
		    int res = preparedStatement.executeUpdate();
		    // TODO add all fields of RIDE class
		} catch (SQLException e) {
			// TODO logger
		}
	}
	
	public Ride createRide(String start, String finish, Date dateTime,
			Profile owner) {
		Ride ride = null;
		try{
		if (search(start, finish, dateTime, owner).size() != 0) {
			throw new BlaCarDomainObjExistsExc("Failed to create new ride: Ride already exist");
		}
		ride = Ride.createRide(start, finish, dateTime, owner);
		//rides.add(ride);
		addRideToDB(ride);
		} catch (BlaCarDomainObjExistsExc ex) {
			LOG.debug("Cannot create ride: " + ex.getMessage(), ex);
			LOG.error("Cannot create ride: " + ex.getMessage());
			}
		return ride;
	}
	
	public List<Ride> search(String start, String finish, Date dateTime,
			Profile owner) {
		List<Ride> ridesFound = new ArrayList<Ride>();

		if (dateTime == null && owner == null && start == null
				&& finish == null) {
			ridesFound = rides;
		} else if (dateTime == null && owner != null && start != null
				&& finish != null) {
			for (Ride ride : rides) {
				if (ride.getStart().equals(start)
						&& ride.getFinish().equals(finish)
						&& ride.getOwner().equals(owner)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		} else if (dateTime != null && owner == null && start != null
				&& finish != null) {
			for (Ride ride : rides) {
				if (ride.getStart().equals(start)
						&& ride.getFinish().equals(finish)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		} else if (dateTime == null && owner == null && start != null
				&& finish != null) {
			for (Ride ride : rides) {
				if (ride.getStart().equals(start)
						&& ride.getFinish().equals(finish)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		} else if (dateTime == null && owner == null && start != null
				&& finish == null) {
			for (Ride ride : rides) {
				if (ride.getStart().equals(start)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		} else if (dateTime == null && owner == null && start == null
				&& finish != null) {
			for (Ride ride : rides) {
				if (ride.getFinish().equals(finish)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		} else {// dateTime != null && owner != null && start != null && finish
				// != null)
			for (Ride ride : rides) {
				if (ride.getStart().equals(start)
						&& ride.getFinish().equals(finish)
						&& ride.getDateTime().equals(dateTime)
						&& ride.getOwner().equals(owner)
						&& !ride.getStatus().equals("expired")) {
					ridesFound.add(ride);
				}
			}
		}
		return ridesFound;
	}

	public List<Ride> search(Map searchParameters) {
		boolean firstRide = true;
		List<Ride> ridesFound = new ArrayList<Ride>();
		
		
		for (Object key : searchParameters.keySet()) {
			if (key.equals(SearchParameters.start.toString())) {
				for (Ride ride : rides) {
					if (firstRide) {
						if (ride.getStart().equals(searchParameters.get(key))) {
							ridesFound.add(ride);
							firstRide = false;
						}
					} else {
						if (!ridesFound.contains(ride)) {
							if (ride.getStart().equals(
									searchParameters.get(key))) {
								ridesFound.add(ride);
							}
						}
					}
				}
			} else if (key.equals(SearchParameters.finish.toString())) {
				for (Ride ride : rides) {
					if (firstRide) {
						if (ride.getFinish().equals(searchParameters.get(key))) {
							ridesFound.add(ride);
							firstRide = false;
						}
					} else {
						if (!ridesFound.contains(ride)) {
							if (ride.getFinish().equals(
									searchParameters.get(key))) {
								ridesFound.add(ride);
							}
						}
					}
				}
			} else if (key.equals(SearchParameters.datetime.toString())) {
				for (Ride ride : rides) {
					if (firstRide) {
						if (ride.getDateTime()
								.equals(searchParameters.get(key))) {
							ridesFound.add(ride);
							firstRide = false;
						}
					} else {
						if (!ridesFound.contains(ride)) {
							if (ride.getDateTime().equals(
									searchParameters.get(key))) {
								ridesFound.add(ride);
							}
						}
					}
				}
			} else if (key.equals(SearchParameters.owner.toString())) {
				for (Ride ride : rides) {
					if (firstRide) {
						if (ride.getOwner().equals(searchParameters.get(key))) {
							ridesFound.add(ride);
							firstRide = false;
						}
					} else {
						if (!ridesFound.contains(ride)) {
							if (ride.getOwner().equals(
									searchParameters.get(key))) {
								ridesFound.add(ride);
							}
						}
					}
				}
			}
		}
		return ridesFound;
	}

	public boolean deleteRide(Ride ride) {
		if (rides.contains(ride)) {
			rides.remove(ride);
			return true;
		} else {
			// to do some code here
			return false;
		}
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rides == null) ? 0 : rides.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RideList other = (RideList) obj;
		if (rides == null) {
			if (other.rides != null)
				return false;
		} else if (!rides.equals(other.rides))
			return false;
		return true;
	}

}