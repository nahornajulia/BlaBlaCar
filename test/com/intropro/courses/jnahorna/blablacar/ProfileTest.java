package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intropro.courses.jnahorna.blablacar.Profile;

public class ProfileTest {

	@Test
	public void testSmoke() {
		Profile profile = new Profile();
		assertNotNull(profile);
	}

}
