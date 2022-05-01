package edu.unlv.mis768.Model;

public class Patient extends User {
	// Fields
	String healthStatus = new String();
	String workSkill = new String();
	int familySize;
	


	// Constructor
	public Patient() {
		
	}
	
	public Patient(User user) {
		username = user.getUsername();
		password = user.getPassword();
	}
	
	public Patient(User user, String p, String hs) {
		username = user.getUsername();
		password = user.getPassword();
		healthStatus = hs;
		
	}

	
	// getters and setters
	
	public int getFamilySize() {
		return familySize;
	}

	public void setFamilySize(int familySize) {
		this.familySize = familySize;
	}
	

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String hs) {
		this.healthStatus = hs;
	}


	public String getWork() {
		return workSkill;
	}

	public void setWork(String ws) {
		this.workSkill = ws;
	}
	
	// Methods
	public Provider findProvider(Provider p) {
		return p;
		
	}
	
	public String toString() {
		return healthStatus + "\n" + workSkill + "\n" + familySize;
	}

}
