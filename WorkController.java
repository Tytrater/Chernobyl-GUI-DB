package edu.unlv.mis768.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.unlv.mis768.Database.Constants;
import edu.unlv.mis768.Database.ProjectDBUtil;
import edu.unlv.mis768.Model.Provider;
import edu.unlv.mis768.Model.Work;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class WorkController extends UserController {

    @FXML
    private RadioButton adminRadioButton;

    @FXML
    private RadioButton managementRadioButton;
    
    @FXML
    private RadioButton tradeRadioButton;

    @FXML
    private TextField openingsTextField;
    
    @FXML
    private TextField titleTextField;

    @FXML
    private Button insertButton;
    
    @FXML
    private Button deleteButton;

    @FXML
    private Button queryButton;
    
    @FXML
    private Button updateButton;


    
    public void initializeWork(Provider prov) {
    	Provider provider = prov;
    }
    
    public void insertButtonListener() throws SQLException {
    	int openings =Integer.parseInt(openingsTextField.getText());
    	String skill = new String();
    	
    	if(adminRadioButton.isSelected())
    		skill = "Administrative";
    	if(managementRadioButton.isSelected())
    		skill = "Management";
    	if(tradeRadioButton.isSelected())
    		skill = "Trade";
    	
    	Work work = new Work(provider,skill, openings);
    	
    	//Create a connection to the database
	    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD);
	    //Insert into table
	    String sqlStatement = "INSERT INTO Work VALUES (?,?,?,?)";
	    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	    
	    //provide the values for the query
	    prepStmt.setString(1, work.getUsername());
	    prepStmt.setString(2, titleTextField.getText());
	    prepStmt.setString(3, skill);
	    prepStmt.setDouble(4, Double.parseDouble(openingsTextField.getText()));
    	
       // Execute Insert Statement
       prepStmt.executeUpdate();
       
       System.out.println(work.getUsername() + " Inserted");
       
       //Close connection
       conn.close();
    }
    
    @FXML
    void queryButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	util.Query("Work", "Name", provider.getUsername());

    }

    @FXML
    void updateButtonListener(ActionEvent event) throws SQLException {
    	String skill = new String();
    	if(tradeRadioButton.isSelected())
    		skill = "Trade";
    	else if(managementRadioButton.isSelected())
    		skill = "Management";
    	else if(adminRadioButton.isSelected())
    		skill = "Administration";
    	System.out.println("Update Method Started");
		//Create a connection to the database
	    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD); 
	    // Create an UPDATE statement to update 
	       String sqlStatement = "UPDATE Work SET JobTitle = ?,"
	       		+ "Skills = ?,"
	    		+ "openings = ?"
	       		+ " WHERE Name = ?";
	    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	    //Provide id to be inserted
	    prepStmt.setString(1, titleTextField.getText());
	    prepStmt.setString(2, skill);
	    prepStmt.setInt(3, Integer.parseInt(openingsTextField.getText()));	
	    prepStmt.setString(4, provider.getUsername());
       // Execute Insert Statement
       prepStmt.executeUpdate();
       
       System.out.println(provider.getUsername() + " Updated");
      
       //Close connection
       conn.close();    	

    }
    
    @FXML
    void deleteButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	util.Delete("Work", "Name", provider.getUsername() );

    }

}
