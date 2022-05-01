package edu.unlv.mis768.Model;

public class Shelter extends Provider {
	// Fields
	
	private int bdrm1;
	private int bdrm2;
	private int bdrm3;
	
	// Constructor
	public Shelter() {
		
	}
	
	public Shelter(Provider provider, int bd1, int bd2, int bd3) {
		address = provider.getAddress();
		username = provider.getUsername();
		password = provider.getPassword();
		patientList = provider.getPatientList();
		phoneNumber = provider.getPhoneNumber();
		bdrm1 = bd1;
		bdrm2 = bd2;
		bdrm3 = bd3;
	}
	
	// getters and setters
	
	public int getBdrm1() {
		return bdrm1;
	}
	public void setBdrm1(int bdrm1) {
		this.bdrm1 = bdrm1;
	}
	public int getBdrm2() {
		return bdrm2;
	}
	public void setBdrm2(int bdrm2) {
		this.bdrm2 = bdrm2;
	}
	public int getBdrm3() {
		return bdrm3;
	}
	public void setBdrm3(int bdrm3) {
		this.bdrm3 = bdrm3;
	}
	
	// Methods
		public String toString() {
			return username + " " + address  +  " "  + phoneNumber + " " + bdrm2 + " " + bdrm2 + " " + bdrm3;
		}
		
		// restricted toString method to display to patients
		public String patientToString() {
			return username + " " + address + " " + phoneNumber;
		}
	
	public void intakePatient(Family fam) {
		
	}
}
