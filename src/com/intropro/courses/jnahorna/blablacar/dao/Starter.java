package com.intropro.courses.jnahorna.blablacar.dao;

import java.util.Date;

import com.main.java.intropro.courses.jnahorna.blablacar.bl.Profile;
import com.main.java.intropro.courses.jnahorna.blablacar.bl.Ride;

public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProfileDAO pd = new ProfileDAO();
		pd.storeProfileToDB(null);
		
		RideDAO rd = new RideDAO();
		rd.storeRideToDB(null);
	}

}
