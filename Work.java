package edu.unlv.mis768.Model;

import java.util.ArrayList;

public class Work extends Provider {
	
	// Fields
	private String skill = new String();
	private int openings;
	
	// Constructor
	public Work() {
		
	}
	
	public Work(Provider provider, String sk, int op) {
		address = provider.getAddress();
		username = provider.getUsername();
		password = provider.getPassword();
		patientList = provider.getPatientList();
		phoneNumber = provider.getPhoneNumber();
		skill = sk;
		openings = op;
	}
	
	// getters and setters
	
	public String getskill() {
		return skill;
	}
	public void setskill(String skill) {
		this.skill = skill;
	}
	public int getOpenings() {
		return openings;
	}
	public void setOpenings(int openings) {
		this.openings = openings;
	}
	
	// Methods
	public String toString() {
		return address + " " + username + " " + password + " " + patientList + " " + phoneNumber + " " + openings;
	}
	
	// restircted toString method to display to patients
	public String patientToString() {
		return username + " " + address + " " + phoneNumber;
	}
	
	

}
