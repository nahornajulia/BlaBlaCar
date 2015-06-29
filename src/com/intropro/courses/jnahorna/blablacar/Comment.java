package com.intropro.courses.jnahorna.blablacar;

import java.util.Date;

public class Comment {

	private Profile owner;
	private String body = "";
	private Date dateTime;

	@Override
	public String toString(){
		String text = owner.getFirstName() + " " + owner.getLastName() + " " + dateTime + "\n\t" + body; 
		return text;
	}
	
	public Profile getOwner() {
		return owner;
	}

	public void setOwner(Profile owner) {
		this.owner = owner;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}