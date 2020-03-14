package com.df.springboot;

import java.io.Serializable;

public class UserPayload implements Serializable {
	private static final long serialVersionUID = -4188689228862450845L;
	
	private String userName;
    private String firstName;
    private String lastName;
    
    public UserPayload(String userName, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	@Override
	public String toString() {
		return "UserPayload [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
