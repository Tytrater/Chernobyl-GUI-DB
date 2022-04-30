package edu.unlv.mis768.Model;

public class User {
	// Fields
	protected String username;
	protected String password;
	
	// No-arg Constructor
	public User() {
		
	}

	// Constructor
	public User(String n, String pw) {
		this.username = n;
		this.password = pw;
	}
	
	// getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return username + " " + password;
	}
	
}
