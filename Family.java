package edu.unlv.mis768.Model;

import java.util.ArrayList;

public class Family extends User {
	protected int shelter;
	protected String surname;
	protected ArrayList<Patient> patientList = new ArrayList<Patient>();

	
	// Constructor
	public Family() {
		
	}
	
	public Family(User user,int shelter, String surname) {
		this.shelter = shelter;
		this.surname = surname;
	}
	
	// getters and setters
	public int getShelter() {
		return shelter;
	}
	public void setShelter(int shelter) {
		this.shelter = shelter;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	// Methods
	public void addPatient(Patient p) {
		patientList.add(p);
	}

}
