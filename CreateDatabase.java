package edu.unlv.mis768.DB;
import java.sql.*;   // Needed for JDBC classes

public class CreateDatabase {
	
		   public static void main(String[] args) {
		      // Create a named constant for the URL.
		      // NOTE: This value is specific for MySQL.
		      final String DB_URL = "jdbc:mysql://localhost:3306/";
		      final String DB_COFFEE_URL = "jdbc:mysql://localhost:3306/projectData";
		      final String USERNAME = "root";
		      final String PASSWORD = "tytraterSQL191712!(!&!@";
		      
		      try {
		         // Create a connection to the database.
		         Connection conn =
		                DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            // Create the database. If the database already exists, drop it. 
		            createDataBase(conn);
		            conn.close();
		            
		         //Create a connection to the database and to the coffee database   
		         Connection conn2 =
		        		 DriverManager.getConnection(DB_COFFEE_URL, USERNAME, PASSWORD);
					
					// Build the Shelter table.
					buildShelterTable(conn2);
					
					// Build the Work table.
					buildWorkTable(conn2);
					
					// Build the HealthCare table.
					buildHealthcareTable(conn2);
					
					// Build the Patient table.
					buildPatientTable(conn2);
					
		         // Close the connection.
		         conn2.close();
		      } catch (Exception ex) {
		         System.out.println("ERROR: "+ ex.getMessage());
		      }
		   }

		   /**
		    * The createDatabase method creates the database. 
		    * If the database already exists, drop the database first.
		    */
		   
		   public static void createDataBase(Connection conn) {
			   System.out.println("Checking for existing database.");
			   
			   try{
				   Statement stmt = conn.createStatement();
				   
				   //Drop the existing database
				   try {
					   stmt.executeUpdate("Drop DATABASE projectData");
				   }
				   catch(SQLException ex) {
						// No need to report an error.
						// The database simply did not exist.
					}
				   //Create a new database
				   try {
					   stmt.execute("Create DATABASE projectData");
					   //stmt.execute("USE coffee");
					   System.out.println("Database projectData created.");
				   }
				   catch(SQLException ex) {
						// No need to report an error.
						// The database simply did not exist.
					}			   
			   }
		  	   catch(SQLException ex) {
		  		   System.out.println("ERROR: "+ ex.getMessage());
		  		   ex.printStackTrace();
				}
		   }
			
			/**
			 * The buildShelterTable method creates the
			 * Shelter table and adds some rows to it.
			 */
			public static void buildShelterTable(Connection conn){
				try { 
		         // Get a Statement object.
		         Statement stmt = conn.createStatement();
		         
					// Create the table.
					stmt.execute("CREATE TABLE Shelter ("+ 
		   				       	 "ShelterTitle CHAR(25) NOT NULL PRIMARY KEY,"+ 
		   				       	 "Address CHAR (75),"+ 
		   				       	 "PhoneNumber CHAR (20),"+ 
		   				         "Size1Capacity INT,"+ 
		   				         "Size2Capacity INT,"+ 
		                         "Size3Capacity INT)");
									 
					// Insert data
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterOne', 'sampleShelterAddress1', '548-25-621', 20,3,1)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwo','sampleShelterAddress2','548-49-621', 8,15,2)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterThree','sampleShelterAddress3','571-25-888', 5,2,10)");
					
					// confirmation message
					System.out.println("Shelter table created.");
				} catch (SQLException ex) {
		         System.out.println("ERROR: "+ex.getMessage());
				}
			}
			
			
			/**
			 * The buildWorkTable method creates the
			 * Work table and adds some rows to it.
			 */
			public static void buildWorkTable(Connection conn){
				try { 
		         // Get a Statement object.
		         Statement stmt = conn.createStatement();
		         
					// Create the table.
					stmt.execute("CREATE TABLE Work ("+
							   "Name CHAR(25) NOT NULL PRIMARY KEY,"+
							   "JobTitle CHAR(25),"+
		   				       "Skills CHAR(25),"+ 
		   				       "Address CHAR(75),"+ 
		   				       "PhoneNumber CHAR(25),"+ 
		                       "openings DOUBLE)");
									 
					// Insert data
					stmt.execute("INSERT INTO Work VALUES ('Emp1','Plumber','Trade','sampleaddress1', '350 44 494 6095', 15)");
					stmt.execute("INSERT INTO Work VALUES ('Emp2','Manager','Management','sampleaddress2','380 44 224 6045', 60)");
					stmt.execute("INSERT INTO Work VALUES ('Emp3','Administrator','Administration','sampleaddress3','381 44 284 6045', 30)"); 
					
					// confirmation message
					System.out.println("Work table created.");
				} catch (SQLException ex) {
		         System.out.println("ERROR: "+ex.getMessage());
				}
			}
			
			
			/**
			 * The buildHealthcareTable method creates the
			 * Health care table and adds some rows to it.
			 */
			public static void buildHealthcareTable(Connection conn){
		      try {
		         // Get a Statement object.
		         Statement stmt = conn.createStatement();
		         
		         // Create the table.
		         stmt.execute("CREATE TABLE Healthcare "+
		            "( ID CHAR(10) NOT NULL PRIMARY KEY,"+
		            "  Title CHAR(50),"    +
		            "  Specialty CHAR(25),"    +
		            "  Hours CHAR(25),"    +
		            "  TelephoneNumber CHAR(25),"    +
		            "  Adress CHAR (75) )");

		         // Add some rows to the new table.
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('100' , 'Dymer Central Town "
		         		+ "Hospital', 'Physical', '0800-1600', '380 44 294 6045',"
		         		+ " 'Revoliutsii St, 320, Dymer, Kyiv Oblast, Ukrain, 07300')");
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('101' , 'Care Mental "
			         		+ "Hospital', 'Mental', '0500-2300', '390 64 344 6565',"
			         		+ " 'Senza St, 320, Dymer, Pripya Oblast, Ukrain, 04905')");         

				 // confirmation message
				 System.out.println("Healthcare table created.");

			  } catch (SQLException ex) {
		         System.out.println("ERROR: "+ex.getMessage());
			  }
			}

		      
		  	/**
				 * The buildShelterTable method creates the
				 * Shelter table and adds some rows to it.
				 */
				public static void buildPatientTable(Connection conn){
					try { 
			         // Get a Statement object.
			         Statement stmt = conn.createStatement();
			         System.out.println("Statement object created");
			         
						// Create the table.
						stmt.execute("CREATE TABLE Patient "+ 
									"( Username CHAR(50)," +
								   " Surname CHAR(50),"+ 
			   				       " HealthStatus CHAR(25),"+ 
			   				       " WorkSkills CHAR(25),"+
			                       " FamilySize CHAR(10) )");
						System.out.println("Patient Table Created");
										 
						// Insert data
						stmt.execute("INSERT INTO Patient VALUES ('Lopez1','Lopez', 'Mental', 'Trade', '3')");
						stmt.execute("INSERT INTO Patient VALUES ('Murphy1','Murphy', 'Mental', 'Trade', '1')");
						stmt.execute("INSERT INTO Patient VALUES ('Fitzgerald1','Fitzgerald', 'Physical', 'Management', '5')");
						stmt.execute("INSERT INTO Patient VALUES ('Smith1','Smith', 'Mental', 'Administrative', '3')");
						stmt.execute("INSERT INTO Patient VALUES ('Johnson1','Johnson', 'Physical', 'Trade', '3')");
						stmt.execute("INSERT INTO Patient VALUES ('Brown1','Brown', 'Mental', 'Trade', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Jones1','Jones', 'Physical', 'Trade', '8')");
						stmt.execute("INSERT INTO Patient VALUES ('Garcia1','Garcia', 'Physical', 'Management', '11')");
						stmt.execute("INSERT INTO Patient VALUES ('Miller1','Miller', 'Physical', 'Management', '6')");
						stmt.execute("INSERT INTO Patient VALUES ('Davis1','Davis', 'Mental', 'Administrative', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Rodriguez1','Rodriguez', 'Mental', 'Administrative', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Gonzalez1','Gonzalez', 'Physical', 'Trade', '3')");
						stmt.execute("INSERT INTO Patient VALUES ('Wilson1','Wilson', 'Mental', 'Management', '4')");
						stmt.execute("INSERT INTO Patient VALUES ('Anderson1','Anderson', 'Physical', 'Trade', '1')");
						stmt.execute("INSERT INTO Patient VALUES ('Thomas1','Thomas', 'Physical', 'Trade', '1')");
						stmt.execute("INSERT INTO Patient VALUES ('Moore1','Moore', 'Physical', 'Trade', '13')");
						stmt.execute("INSERT INTO Patient VALUES ('Taylor1','Taylor', 'Mental', 'Administrative', '4')");
						stmt.execute("INSERT INTO Patient VALUES ('Lee1','Lee', 'Mental', 'Management', '4')");
						stmt.execute("INSERT INTO Patient VALUES ('Perez1','Perez', 'Physical', 'Trade', '3')");
						stmt.execute("INSERT INTO Patient VALUES ('White1','White', 'Mental', 'Trade', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Harris1','Harris', 'Physical', 'Trade', '6')");
						stmt.execute("INSERT INTO Patient VALUES ('Sanchez1','Sanchez', 'Mental', 'Administrative', '7')");
						stmt.execute("INSERT INTO Patient VALUES ('Ramirez1','Ramirez', 'Physical', 'Administrative', '1')");
						stmt.execute("INSERT INTO Patient VALUES ('Young1','Young', 'Mental', 'Trade', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Allen1','Allen', 'Mental', 'Management', '2')");
						stmt.execute("INSERT INTO Patient VALUES ('Wright1','Wright', 'Mental', 'Trade', '3')");
						
						
						// confirmation message
						System.out.println("Patient values inserted");
					} catch (SQLException ex) {
			         System.out.println("ERROR: "+ex.getMessage());
					}
		      
			}

}
