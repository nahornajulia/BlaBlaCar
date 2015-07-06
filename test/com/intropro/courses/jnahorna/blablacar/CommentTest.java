package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.main.java.intropro.courses.jnahorna.blablacar.bl.Comment;

public class CommentTest {

	@Test
	public void testSmoke() {
		Comment comment = new Comment();
		assertNotNull(comment);
	}
}
