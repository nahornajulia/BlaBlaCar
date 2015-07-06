package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.main.java.intropro.courses.jnahorna.blablacar.bl.Profile;

public class ProfileTest {

	@Test
	public void testSmoke() {
		Profile profile = new Profile();
		assertNotNull(profile);
	}

}
