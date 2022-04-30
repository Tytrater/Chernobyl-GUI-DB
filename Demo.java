/**
 * 
 */
package edu.unlv.mis768.Model;

import java.util.ArrayList;

/**
 * @author Tyler
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList Simulate Database
		
		// Sample User- patient
		String userName = "Tyler";
		int id = 1;
		String userPassword = "mis768";
		User user = new User(userName, userPassword);
		
		// Sample User- Provider
		String providerName="test";
		int providerId = 2;
		String providerPassword="provider";
		User userProvider = new User(providerName, providerPassword);
		
		// Sample Family
		
		
		int shelter = 1;
		String sur = "Williams";
		Family fam = new Family(user, shelter, sur);
		
		// Sample Patient
		ArrayList<String> phy = new ArrayList<String>(5);
		phy.add("Concussion");
		ArrayList<String> mental = new ArrayList<String>();
		mental.add("Anxiety");
		ArrayList<String> wk = new ArrayList<String>();
		wk.add("trade");
		
		// Create Patient Object
		Patient patient = new Patient(user, phy,mental,wk);
		//User user
		
		//Sample Provider
		 //* Probably not needed as subclasses wil be using the system
		String address = "sample address 1";
		String phoneNumber = "7028851234";
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		// Create Provider Object
		Provider provider = new Provider(userProvider,address,phoneNumber,patientList);		
		
		
		//  Sample Work Provider
		
		ArrayList<String> skills = new ArrayList<String>();
		// Loop Needed
		//skills.add(work.getSkills());
		int openings = 5;
		
		// Create Work Provider object
		Work work = new Work(provider, skills, openings);
		
		// Loop Needed
		//patientList.add(work.getPassword());
		
		// Sample Healthcare Provider
		
		// Sample Shelter Provider
		
		
		
		// Display objects
		String message = "";
		message += "User-Patient: " + user.toString() + "\n";
		message += "User-Provider: " + userProvider.toString() + "\n";
		message += "Patient: " + patient.toString() + "\n";
		message += "Provider: " + provider.toString() + "\n";
		message += "Provider-Work: " + work.toString() + "\n";
	
		System.out.print(message);
		
		
		

	}

}
