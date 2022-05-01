package edu.unlv.mis768.Model;

import java.util.ArrayList;

public class Provider extends User {
	// Fields
	
	protected String address = new String();
	protected String phoneNumber;
	protected ArrayList<String> specialty = new ArrayList<String>();
	protected ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	// Constructor
	public Provider() {
		
	}
	
	public Provider(User user, String a, String pn, ArrayList<Patient> p) {
		username = user.getUsername();
		password = user.getPassword();
		address = a;
		phoneNumber = pn;
		for (int i = 0; i < p.size(); i++)
			patientList.add(p.get(i));
	}
	
	// getters and setters
	
	public Provider(User user, String a, String pn) {
		username = user.getUsername();
		password = user.getPassword();
		address = a;
		phoneNumber = pn;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String ad) {
		address = ad;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String pn) {
		this.phoneNumber = pn;
	}
	public ArrayList<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}
	
	// Methods
	public Patient intakePatient(Patient p) {
		return p;
	}
	
	public String toString() {
		String message = "Username: " + username + "\n";
		message += "Password: " + password + "\n";
		message += "address: " + address + "\n";
		message += "Phone Number: " + phoneNumber + "\n";
		return message;
	}
	
	
	/*
	public Provider copy() {
		
	}
	*/

}
