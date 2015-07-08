package com.main.java.intropro.courses.jnahorna.blablacar.bl;

public class Profile {

	private String first_name;
	private String last_name;
	private String phone_number;
	private String email;
    private int id;
    
	//Getters and Setters
	//***************************************************	
	public int getId(){
		return id;
	}
    public void setId(int id){
    	this.id=id;
    }
	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone_number;
	}

	public void setPhone(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// *************************************************

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (phone_number == null) {
			if (other.phone_number != null)
				return false;
		} else if (!phone_number.equals(other.phone_number))
			return false;
		return true;
	}

}
