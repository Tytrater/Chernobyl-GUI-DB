package edu.unlv.mis768.Model;

import java.util.ArrayList;

public class Patient extends User {
	// Fields
	ArrayList<String> physical = new ArrayList<String>();
	ArrayList<String> mental = new ArrayList<String>();
	ArrayList<String> work = new ArrayList<String>();
	
	// Constructor
	public Patient() {
		
	}
	
	public Patient(User user) {
		username = user.getUsername();
		password = user.getPassword();
	}
	
	public Patient(User user, ArrayList<String> p, ArrayList<String> m, ArrayList<String> w) {
		username = user.getUsername();
		password = user.getPassword();
		physical = p;
		mental = m;
		work = w;
		
	}

	
	// getters and setters
	

	public ArrayList<String> getPhysical() {
		return physical;
	}

	public void setPhysical(ArrayList<String> physical) {
		this.physical = physical;
	}

	public ArrayList<String> getMental() {
		return mental;
	}

	public void setMental(ArrayList<String> mental) {
		this.mental = mental;
	}

	public ArrayList<String> getWork() {
		return work;
	}

	public void setWork(ArrayList<String> work) {
		this.work = work;
	}
	
	// Methods
	public Provider findProvider(Provider p) {
		return p;
		
	}
	
	public String toString() {
		return physical + "\n" + mental + "\n" + work;
	}

}
