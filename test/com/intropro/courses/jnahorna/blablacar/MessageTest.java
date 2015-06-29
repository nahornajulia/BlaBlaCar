package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intropro.courses.jnahorna.blablacar.Message;

public class MessageTest {

	@Test
	public void testSmoke() {
		Message message = new Message();
		assertNotNull(message);
	}

}