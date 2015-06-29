package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.intropro.courses.jnahorna.blablacar.Profile;
import com.intropro.courses.jnahorna.blablacar.Ride;
import com.intropro.courses.jnahorna.blablacar.RideList;

public class RideTest {

	@Test
	public void testCreateRequest() {
		Date date = new Date();
		Profile owner = new Profile();
		Profile requestOwner = new Profile();
		requestOwner.setFirstName("Test1");
		Profile requestOwner2 = new Profile();
		requestOwner.setFirstName("Test2");
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date, owner);

		Request request;
		try {
			request = ride.createRequest(requestOwner);

			assertNotNull(request);
			assertTrue(!ride.getRequests().isEmpty());
			assertEquals(request, ride.getRequests().get(0));
			assertEquals("initial", ride.getRequests().get(0).getStatus());
             
			Request request2 = ride.createRequest(requestOwner);
			assertEquals(request2, request);
			ride.createRequest(requestOwner2);
			assertEquals(2, ride.getRequests().size());
			

		} catch (BlaCarDomainObjExistsExc e) {
			Logger.getLogger(this.getClass())
					.error("can't create a request", e);
			fail("request was not created");
		}
	}

	@Test
	public void testDeleteRequest() {
		Date date = new Date();
		Profile owner = new Profile();
		Profile requestOwner = new Profile();
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date, owner);

		Request request;
		try {
			request = ride.createRequest(requestOwner);

			assertTrue(!ride.getRequests().isEmpty());
			ride.deleteRequest(request);
			assertTrue(ride.getRequests().isEmpty());
			assertTrue(!ride.deleteRequest(request));
		} catch (BlaCarDomainObjExistsExc e) {

			Logger.getLogger(this.getClass()).error("can't delete request", e);
			fail("request was not deleted");
		}// check somehow that you can't
			// delete same object two
			// times and no uncaughted
			// exceptions

	}

	@Test
	public void testGetRequest() {

		Date date = new Date();
		Profile rideOwner = new Profile();
		// create two request owners
		Profile requestOwner = new Profile();
		requestOwner.setFirstName("Test1");
		Profile requestOwner2 = new Profile();
		requestOwner2.setFirstName("Test2");
		// create rideList
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date,
				rideOwner);
		try {
			ride.createRequest(requestOwner2);
			Request request = ride.createRequest(requestOwner);

			assertEquals(request, ride.getRequest(requestOwner));
			try {
				ride.getRequest(rideOwner);
			} catch (BlaCarDomainObjNotExistExc e) {
				Logger.getLogger("exception test").info(
						"we caught expected exception here ");
			}
		} catch (BlaCarDomainObjNotExistExc e) {
			Logger.getLogger(this.getClass()).error("can't get request", e);
			fail("Should throw exeption");
		} catch (BlaCarDomainObjExistsExc e) {
			Logger.getLogger(this.getClass()).error("can't get request", e);
			fail("Should throw exeption");
		}
	}

	@Test
	public void testSearchRequestsNotResponded() {
		Date date = new Date();
		Profile owner = new Profile();
		Profile requestOwner = new Profile();
		requestOwner.setFirstName("Test1");
		Profile requestOwner2 = new Profile();
		requestOwner2.setFirstName("Test2");
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date, owner);
		try {
			ride.createRequest(requestOwner);

			ride.createRequest(requestOwner2);

			assertEquals(2, ride.searchRequestsNotResponded().size());

			ride.getRequest(requestOwner2).setStatus("confirmed");
			assertEquals(1, ride.searchRequestsNotResponded().size());

			ride.getRequest(requestOwner).setStatus("denied");
			assertEquals(0, ride.searchRequestsNotResponded().size());

		} catch (BlaCarDomainObjExistsExc e) {
			Logger.getLogger(this.getClass()).error("can't search request", e);
			fail("request was not found");
		}
	}

	@Test
	public void testCreateComment() {
		Date date = new Date();
		Profile owner = new Profile();
		RideList rideList = new RideList();
		Ride ride = rideList.createRide("Cristall", "Grygorenka", date, owner);

		Comment comment = ride.createComment(owner, "My first comment");
		assertNotNull(comment);
		assertTrue(!ride.getComments().isEmpty());
		assertEquals(comment, ride.getComments().get(0));
		assertEquals(owner, ride.getComments().get(0).getOwner());
		assertEquals("My first comment", ride.getComments().get(0).getBody());
	}

	@Test
	public void testShowComment() {

	}
}
