package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

public class MessageListTest {
	
	@Test
	public void testSendMessage(){
		Profile from = new Profile();
		from.setFirstName("Test1");
		Profile to = new Profile();
		to.setFirstName("Test2");
		String body = "Message from " + from.getFirstName() + " to " + to.getFirstName();
		MessageList messages = new MessageList();
		Message message = messages.sendMessage(from, to, body);
		assertNotNull(message);
		assertEquals(body, message.getBody());
		assertEquals("Test1", message.getFrom().getFirstName());
		assertEquals("Test2", message.getTo().getFirstName());
		Data dateMessage = new Date();
		assertEquals(dateMessage, message.getDateTime());
		
	}

}
