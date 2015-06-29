package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import java.util.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.intropro.courses.jnahorna.blablacar.Request;

public class RequestTest {

	@Test
	public void testSmoke() {
		Request request = new Request();
		assertNotNull(request);
	}
	
	/*
	@Test
	public void testNotifyRequest(){
		fail("Not implemented yet");
	}
	*/
	
	@Test
	public void testConfirmRequest(){
		Date date = new Date();
		Profile rideOwner = new Profile();
		Profile requestOwner = new Profile();
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date, rideOwner);
		
		try {
			Request request = ride.createRequest(rideOwner);
		} catch (BlaCarDomainObjExistsExc e) {
			Logger.getLogger(this.getClass()).error("can't create a request", e);
			fail("request was not created");
		}
		assertEquals("initial", ride.getRequests().get(0).getStatus());
		
		ride.getRequest(requestOwner).setStatus("confirmed");
		assertEquals("confirmed",ride.getRequest(requestOwner).getStatus());
	}
	
	/*
	@Test
	public void testDenyRequest(){
		fail("Not implemented yet");
	}
	*/
}
