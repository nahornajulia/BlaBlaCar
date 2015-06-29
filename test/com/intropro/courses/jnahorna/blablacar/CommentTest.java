package com.intropro.courses.jnahorna.blablacar;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intropro.courses.jnahorna.blablacar.Comment;

public class CommentTest {

	@Test
	public void testSmoke() {
		Comment comment = new Comment();
		assertNotNull(comment);
	}
}
