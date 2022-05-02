package edu.unlv.mis768.chernobylSam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import edu.unlv.mis768.Database.Constants;
import edu.unlv.mis768.Database.ProjectDBUtil;
import edu.unlv.mis768.Model.Provider;
//import edu.unlv.mis768.Database.shelter;
import edu.unlv.mis768.Model.Shelter;
import edu.unlv.mis768.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ShelterController extends UserController {

    @FXML
    private Button ClearButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button insertButton;

    @FXML
    private TextField size1TextField;

    @FXML
    private TextField size2TextField;

    @FXML
    private TextField size3TextField;
    
    Provider provider = new Provider();
    
    public void initializeProvider(Provider prov) {
    	provider = prov;
    	System.out.println("ShelterController Initialized: " + provider);
    }

    @FXML
    void ClearButtonListener(ActionEvent event) {
    	size1TextField.clear();
    	size2TextField.clear();
    	size3TextField.clear();

    }

    @FXML
    void deleteButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	util.Delete("Shelter", "ShelterTitle", provider.getUsername() );

    }

    @FXML
    void updateButtonListener(ActionEvent event) throws SQLException {
    	int size1 = Integer.parseInt(size1TextField.getText());
    	int size2 = Integer.parseInt(size2TextField.getText());
    	int size3 = Integer.parseInt(size3TextField.getText());
    	Shelter shelter = new Shelter(provider,size1, size2, size3);
    	
    	System.out.println("Update Method Started");
		//Create a connection to the database
	    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD); 
	    // Create an UPDATE statement to update 
	       String sqlStatement = "UPDATE Shelter SET Size1Capacity = ?,"
	       		+ "Size2Capacity = ?,"
	    		+ "Size3Capacity = ?"
	       		+ " WHERE ShelterTitle = ?";
	    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	    //Provide id to be inserted
	    prepStmt.setInt(1, size1);
	    prepStmt.setInt(2, size2);
	    prepStmt.setInt(3, size3);	
	    prepStmt.setString(4, provider.getUsername());
       // Execute Insert Statement
       prepStmt.executeUpdate();
       
       System.out.println(shelter.getUsername() + " Updated");
      
       //Close connection
       conn.close();
      
       
    	

    }
    
    @FXML
    void queryButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	util.Query("Shelter", "ShelterTitle", provider.getUsername());
    }
    

    @FXML
    void insertButtonListener(ActionEvent event) throws SQLException {
    	int size1 = Integer.parseInt(size1TextField.getText());
    	int size2 = Integer.parseInt(size2TextField.getText());
    	int size3 = Integer.parseInt(size3TextField.getText());
    	Shelter shelter = new Shelter(provider,size1, size2, size3);
    	
    	System.out.println("Insert Method Started");
		//Create a connection to the database
	    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD); 
	    // Sql Statement to insert row
	    String sqlStatement = "INSERT INTO Shelter VALUES (?,?,?,?)";
	    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	    //Provide id to be inserted
	    prepStmt.setString(1,shelter.getUsername());
	    prepStmt.setInt(2, size1);
	    prepStmt.setInt(3, size2);
	    prepStmt.setInt(4, size3);	    
       // Execute Insert Statement
       prepStmt.executeUpdate();
       
       System.out.println(shelter.getUsername() + " Inserted");
       
       //Close connection
       conn.close();
       
    }

}
