package edu.unlv.mis768.Model;

public class Healthcare extends Provider {
	
	// Fields
	
	private String specialty = new String();
	private String businessHours = new String();
	
	// Constructors
	public Healthcare() {
		
		
	}
	
	public Healthcare(Provider provider) {
		address = provider.getAddress();
		username = provider.getUsername();
		password = provider.getPassword();
		patientList = provider.getPatientList();
		phoneNumber = provider.getPhoneNumber();
		
		
	}
	
	// getters and setters

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	
	public String toString() {
		return username + " " + password + " " + address + " " + phoneNumber + " " + businessHours;
	}
	
	// restricted toString method to display to patient
	public String patientToString() {
		return username + " " + address + " " + phoneNumber+ " " + businessHours;
	}
	

}
