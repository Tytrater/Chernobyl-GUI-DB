package edu.unlv.mis768.GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.unlv.mis768.DB.Constants;
import edu.unlv.mis768.Model.Healthcare;
import edu.unlv.mis768.Model.Patient;
import edu.unlv.mis768.Model.Shelter;
import edu.unlv.mis768.Model.User;
import edu.unlv.mis768.Model.Work;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PatientController extends UserController{

    @FXML
    private RadioButton administrativeButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField familySizeText;

    @FXML
    private RadioButton managementButton;

    @FXML
    private RadioButton mentalCareButton;

    @FXML
    private RadioButton physicalCareButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField surnameText;

    @FXML
    private RadioButton tradeButton;
    
    @FXML
    private Label healthLabel;
    
    @FXML
    private Label shelterLabel;
    
    @FXML
    private Label workLabel;
    
    
    
    public void clearButtonListener() {
    	surnameText.setText("");
    	familySizeText.setText("");
    }


    	public void insertButtonListener() throws SQLException  {
    		
    		//Create patient object
    		User patient = new User();
    		
	    	// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
	    	
	    	
	    	//create variables
	    	String healthStatus;
	    	String workSkills;
	    	String surname;
	    	Double familySize;
	    	String username;
	    	
	    	//Get the user name
	    	username = patient.getUsername();
	    	
	    	
	    	surname = surnameText.getText();
	    	familySize = Double.parseDouble(familySizeText.getText());
	    	
	    	if(mentalCareButton.isSelected()) {
	    		healthStatus = "Mental";	    	
	    		}
	    	else {
	    		healthStatus = "Physical";
	    	}
	    	
	    	
	    	//Set the work skills variable
	    	if(tradeButton.isSelected()) {
	    		workSkills = "Trade";
	    	}
	    	else if(managementButton.isSelected()) {
	    		workSkills = "Management";
	    	}
	    	else {
	    		workSkills = "Administrative";
	    	}
	    	
	    	
	    	//Create a connection to the database
		    Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
		    
		    //Create a SELECT statement to get the specific field row from the patient table
		    String sqlStatement = "INSERT INTO Patient VALUES (?,?,?,?,?)";
		    
		    //Instantiate a PrepareStatement object using the SQL command
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
		    
		    //provide the values for the query
		    prepStmt.setString(1, username);
		    prepStmt.setString(2, surname);
		    prepStmt.setString(2, healthStatus);
		    prepStmt.setString(3, workSkills);
		    prepStmt.setDouble(4, familySize);
		    
	       //Close connection
	       conn.close();
	    	
	    }
	
    	
    	public void deleteButtonListener() throws SQLException {
    		
    		//Create patient object
    		User patient = new User();
    		
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    String username;
		    
		    username = patient.getUsername();
		    
		  //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
    		
    		
    		String sql ="DELETE FROM Patient WHERE Username = ?";
			
			//Prepared statement object
			PreparedStatement prepStmt;
			
			prepStmt = conn.prepareStatement(sql);
	
			//Provide value
			prepStmt.setString(1, username);
			
			//Execute it
			int rows = prepStmt.executeUpdate();
			System.out.println(rows+" rows deleted");
    	}
    	
    	
    	
    	public void updateButtonListener() throws SQLException{
    		
    		//Create patient object
    		User patient = new User();
    		
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    //Create local variables
		    String username;
		    String healthStatus;
		    
		    //Get the user's surname from the user's text input
		    username = patient.getUsername();
		    
		    //Get the user's health status based on which button they selected
		    if(mentalCareButton.isSelected()) {
	    		healthStatus = "Mental";	    	
	    		}
	    	else {
	    		healthStatus = "Physical";
	    	}
    		
    		
		   // Create an UPDATE statement to update the user's health status for the specified user-name.
 	       String sqlStatement = "UPDATE Patient SET HealthStatus = ? WHERE Username = ?";
 	       
 	       //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
 	       
 	   
 	        // instantiate a PrepareStatement object using the SQL command
 	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
 	        
 	        // provide the values for Update command.
 	        prepStmt.setString(1, healthStatus);
 	        prepStmt.setString(2, username);
 			
 	       // Send the UPDATE statement to the DBMS.
 	       int rows = prepStmt.executeUpdate();
 	       
	       //Close connection
	       conn.close();

 	       // Display the results.
 	       System.out.println(rows + " row(s) updated.");
    		
    	}
    	
        @FXML
        void findProviderButtonListener(ActionEvent event) throws SQLException {

        	// Create patient object
        	Patient patient = new Patient(user);
        	
        	// Create shelter provider object
        	Shelter shelter = new Shelter();
        	
        	// Create work provider object
        	Work work = new Work();
        	
        	// Create healthcare provider object
        	Healthcare health = new Healthcare();
        	
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_Project_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    // Create SQL Select statement for patient
		    String sqlStatement = "SELECT * FROM Patient Where Username = '" + user.getUsername() + "'";
		    
 	       //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
		   
	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // Send SELECT statement to RDMS
	        ResultSet result =  prepStmt.executeQuery();
	        
	        if (result.next()) {
	        	patient.setHealthStatus(result.getString("HealthStatus"));
	        	patient.setWork(result.getString("WorkSkills"));
	        	patient.setFamilySize(result.getInt("FamilySize"));
	        }
	        else
	        	System.out.println("User" + user.getUsername() + " not found");
	        	
		    // Create SQL statement to find matching Health provider
	        sqlStatement = "SELECT * FROM Healthcare WHERE Specialty = '" + patient.getHealthStatus() + "' LIMIT 1";
	        
	        // instantiate a PrepareStatement object using the SQL command
	        prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // Send SELECT statement to RDMS
	        result =  prepStmt.executeQuery();
	        
	        if (result.next()) {
	        	System.out.println("health username: " + result.getString("Title"));
	        	health.setUsername(result.getString("Title"));
	        	health.setSpecialty(result.getString("Specialty"));
	        	health.setPhoneNumber(result.getString("TelephoneNumber"));
	        	health.setAddress(result.getString("Adress"));
	        }
	        else
	        	System.out.println("Health Provider " + patient.getHealthStatus() + " not found");
	        
	     // Create SQL statement to find matching Work provider
	        sqlStatement = "SELECT * FROM Work WHERE Skills = '" + patient.getWork() + "'LIMIT 1";
	        
	        // instantiate a PrepareStatement object using the SQL command
	        prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // Send SELECT statement to RDMS
	        result =  prepStmt.executeQuery();
	        
	        if (result.next()) {
	        	work.setUsername(result.getString("Name"));
	        	work.setskill(result.getString("Skills"));
	        	work.setOpenings(result.getInt("openings"));
	        	work.setAddress(result.getString("Address"));
	        	work.setPhoneNumber(result.getString("PhoneNumber"));
	        }
	        else
	        	System.out.println("Work " + patient.getWork() + "Not found");
	        
	        
	     // Create SQL statement to find matching Shelter provider
	        if (patient.getFamilySize() <=3)
	        	sqlStatement = "SELECT * FROM Shelter WHERE Size1Capacity > 0 LIMIT 1";
	        else if(patient.getFamilySize() <= 8)
	        	sqlStatement = "SELECT * FROM Shelter WHERE Size2Capacity > 0 LIMIT 1";
	        else
	        	sqlStatement = "SELECT * FROM Shelter WHERE Size3Capacity > 0 LIMIT 1";
	        
	        // instantiate a PrepareStatement object using the SQL command
	        prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // Send SELECT statement to RDMS
	        result =  prepStmt.executeQuery();
	        
	        if (result.next()) {
	        	shelter.setUsername(result.getString("ShelterTitle"));
	        	shelter.setBdrm1(result.getInt("Size1Capacity"));
	        	shelter.setBdrm2(result.getInt("Size2Capacity"));
	        	shelter.setBdrm3(result.getInt("Size3Capacity"));
	        	shelter.setAddress(result.getString("Address"));
	        	shelter.setPhoneNumber(result.getString("PhoneNumber"));
	        	
	        }
	        
	        // Display for console
	        String message = "";
	        message += "Healthcare provider: " + health.toString();
	        message += "\n Shelter provider: " + shelter.toString();
	        message += "\n Work provider: " + work.toString();
	        System.out.println(message);
	        
	        // Display to user
	        healthLabel.setText(health.toString());
	        shelterLabel.setText(shelter.patientToString());
	        workLabel.setText(work.patientToString());

	        
	       //Close connection
	       conn.close();        	
        	
        }

}
