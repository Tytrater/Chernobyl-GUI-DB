package GroupProject;
import java.sql.*;   // Needed for JDBC classes

public class CreateDatabase {
	
		   public static void main(String[] args) {
		      // Create a named constant for the URL.
		      // NOTE: This value is specific for MySQL.
		      final String DB_URL = "jdbc:mysql://localhost:3306/";
		      final String DB_COFFEE_URL = "jdbc:mysql://localhost:3306/projectData";
		      final String USERNAME = "root";
		      final String PASSWORD = "samigirl65";
		      
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
					stmt.execute("CREATE TABLE Shelter "+ 
		   				       	 "( ShelterTitle CHAR(25) NOT NULL PRIMARY KEY,"+ 
		   				       	 " Address CHAR(75),"+ 
		   				       	 " PhoneNumber CHAR(50),"+ 
		   				         " Size1Capacity INT,"+ 
		   				         " Size2Capacity INT,"+ 
		                         " Size3Capacity INT )");
									 
					// Insert data
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterOne', 'sampleShelterAddress1', '548-25-621', 20,3,1)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwo','sampleShelterAddress2','548-49-621', 8,15,2)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterThree','sampleShelterAddress3','571-25-888', 5,2,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterFour','sampleShelterAddress4','222-25-998', 3,4,20)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterFive','sampleShelterAddress5','555-25-555', 2,2,20)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterSix','sampleShelterAddress6','571-99-999', 2,8,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterSeven','sampleShelterAddress7','654-33-888', 4,4,4)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterEight','sampleShelterAddress8','441-55-888', 55,2,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterNine','sampleShelterAddress9','444-45-449', 5,10,12)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTen','sampleShelterAddress10','333-33-338', 9,4,12)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterEleven','sampleShelterAddress11','221-22-333', 2,2,9)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwelve','sampleShelterAddress12','444-25-4444', 5,2,5)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterThirteen','sampleShelterAddress13','001-25-008', 6,8,9)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterFourteen','sampleShelterAddress14','022-15-188', 5,4,4)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterFifteen','sampleShelterAddress15','8871-15-811', 5,5,4)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterSixteen','sampleShelterAddress16','522-25-7873', 5,2,5)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterSeventeen','sampleShelterAddress17','331-25-888', 2,2,5)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterEighteen','sampleShelterAddress18','022-25-0000', 5,3,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterNineteen','sampleShelterAddress19','531-25-3438', 3,4,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwenty','sampleShelterAddress20','572-15-888', 5,2,9)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwentyOne','sampleShelterAddress21','331-25-488', 1,2,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwentyTwo','sampleShelterAddres22','333-25-8845', 1,2,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwentyThree','sampleShelterAddress23','331-25-888', 5,2,4)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwentyFour','sampleShelterAddress24','271-25-888', 5,8,10)");
					stmt.execute("INSERT INTO Shelter VALUES ('ShelterTwentyFive','sampleShelterAddress25','221-15-348', 5,4,10)");
					
					
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
		         System.out.println("Statement object created");
		         
					// Create the table.
					stmt.execute("CREATE TABLE Work "+ 
								"( Name CHAR(50)," +
							   " JobTitle CHAR(50),"+ 
		   				       " Skills CHAR(25),"+ 
		   				       " Address CHAR(75),"+
		   				       " PhoneNumber CHAR(75),"+
		                       " Openings CHAR(10) )");
					System.out.println("Work Table Created");
									 
					// Insert data
					stmt.execute("INSERT INTO Work VALUES ('emp1','Plumber', 'Trade', 'sampleAddress1', '350 44 494 6095', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp2','Manager', 'Management', 'sampleAddress2', '678 40 214 6325', '20')");
					stmt.execute("INSERT INTO Work VALUES ('emp3','Administrator', 'Administration', 'sampleAddress3', '111 22 333 444', '30')");
					stmt.execute("INSERT INTO Work VALUES ('emp4','Plumber', 'Trade', 'sampleAddress4', '222 34 444 555', '5')");
					stmt.execute("INSERT INTO Work VALUES ('emp5','Plumber', 'Trade', 'sampleAddress5', '667 74 888 999', '10')");
					stmt.execute("INSERT INTO Work VALUES ('emp6','Manager', 'Management', 'sampleAddress6', '122 13 144 6155', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp7','Administrator', 'Administration', 'sampleAddress7', '221 22 223 224', '25')");
					stmt.execute("INSERT INTO Work VALUES ('emp8','Manager', 'Management', 'sampleAddress8', '888 77 666 5555', '35')");
					stmt.execute("INSERT INTO Work VALUES ('emp9','Plumber', 'Trade', 'sampleAddress9', '332 00 111 0000', '10')");
					stmt.execute("INSERT INTO Work VALUES ('emp10','Plumber', 'Trade', 'sampleAddress10', '000 11 777 6995', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp11','Manager', 'Management', 'sampleAddress11', '999 44 323 6985', '25')");
					stmt.execute("INSERT INTO Work VALUES ('emp12','Manager', 'Management', 'sampleAddress12', '345 67 890 1234', '10')");
					stmt.execute("INSERT INTO Work VALUES ('emp13','Manager', 'Management', 'sampleAddress13', '432 89 999 9991', '5')");
					stmt.execute("INSERT INTO Work VALUES ('emp14','Plumber', 'Trade', 'sampleAddress14', '999 01 100 2323', '20')");
					stmt.execute("INSERT INTO Work VALUES ('emp15','Plumber', 'Trade', 'sampleAddress15', '896 57 464 9995', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp16','Plumber', 'Trade', 'sampleAddress16', '123 21 233 1111', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp17','Administrator', 'Administration', 'sampleAddress17', '546 78 001 0000', '30')");
					stmt.execute("INSERT INTO Work VALUES ('emp18','Administrator', 'Administration', 'sampleAddress18', '989 67 1919 3429', '35')");
					stmt.execute("INSERT INTO Work VALUES ('emp19','Administrator', 'Administration', 'sampleAddress19', '349 78 483 6325', '5')");
					stmt.execute("INSERT INTO Work VALUES ('emp20','Plumber', 'Trade', 'sampleAddress20', '300 40 500 6000', '1')");
					stmt.execute("INSERT INTO Work VALUES ('emp21','Plumber', 'Trade', 'sampleAddress21', '700 80 900 1000', '7')");
					stmt.execute("INSERT INTO Work VALUES ('emp22','Manager', 'Management', 'sampleAddress22', '345 44 434 6775', '19')");
					stmt.execute("INSERT INTO Work VALUES ('emp23','Administrator', 'Administration', 'sampleAddress23', '351 24 494 6495', '10')");
					stmt.execute("INSERT INTO Work VALUES ('emp24','Plumber', 'Trade', 'sampleAddress24', '770 24 494 7995', '15')");
					stmt.execute("INSERT INTO Work VALUES ('emp25','Plumber', 'Trade', 'sampleAddress25', '050 14 411 6655', '10')");
					
				
					
					
					// confirmation message
					System.out.println("Patient values inserted");
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
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('102' , 'Hope "
			         		+ "Hospital', 'Mental', '0500-2200', '110 64 114 6565',"
			         		+ " 'Address3')");   
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('103' , 'Happy "
			         		+ "Hospital', 'Physical', '0400-2200', '900 64 224 6565',"
			         		+ " 'Address4')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('104' , 'Love "
			         		+ "Hospital', 'Mental', '0500-2000', '220 64 114 9965',"
			         		+ " 'Address5')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('105' , 'Euphoria "
			         		+ "Hospital', 'Mental', '0500-2200', '345 64 134 6685',"
			         		+ " 'Address6')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('106' , 'Wellness "
			         		+ "Hospital', 'Mental', '0900-2200', '110 64 414 6795',"
			         		+ " 'Address7')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('107' , 'Sunshine "
			         		+ "Hospital', 'Physical', '0500-2200', '110 64 114 7777',"
			         		+ " 'Address8')"); 
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('108' , 'Happiness "
			         		+ "Hospital', 'Mental', '0700-2200', '555 65 554 6565',"
			         		+ " 'Address9')"); 
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('109' , 'View "
			         		+ "Hospital', 'Physical', '0300-2200', '110 64 884 8865',"
			         		+ " 'Address10')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('110' , 'Blue "
			         		+ "Hospital', 'Mental', '0500-2200', '440 74 114 7875',"
			         		+ " 'Address11')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('111' , 'Red "
			         		+ "Hospital', 'Mental', '0500-2200', '440 74 554 6666',"
			         		+ " 'Address12')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('112' , 'Purple "
			         		+ "Hospital', 'Physical', '0430-2200', '888 77 444 7335',"
			         		+ " 'Address13')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('113' , 'Yellow "
			         		+ "Hospital', 'Mental', '0400-2300', '140 74 111 2222',"
			         		+ " 'Address14')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('114' , 'Green "
			         		+ "Hospital', 'Physical', '0500-2200', '420 99 314 2223',"
			         		+ " 'Address15')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('115' , 'Orange "
			         		+ "Hospital', 'Physical', '0500-2200', '340 34 133 3333',"
			         		+ " 'Address16')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('116' , 'Winter "
			         		+ "Hospital', 'Physical', '0300-2100', '222 22 224 7225',"
			         		+ " 'Address17')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('117' , 'Summer "
			         		+ "Hospital', 'Mental', '0300-2200', '740 84 664 4645',"
			         		+ " 'Address18')");
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('118' , 'Fall "
			         		+ "Hospital', 'Mental', '0500-2300', '333 34 224 1111',"
			         		+ " 'Address19')"); 
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('119' , 'Spring "
			         		+ "Hospital', 'Physical', '0500-2200', '444 74 114 4444',"
			         		+ " 'Address20')"); 
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('120' , 'Autumn "
			         		+ "Hospital', 'Mental', '0500-2200', '340 74 334 7445',"
			         		+ " 'Address21')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('121' , 'Centennial "
			         		+ "Hospital', 'Physical', '0500-2300', '111 74 774 7875',"
			         		+ " 'Address22')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('122' , 'Rainbow "
			         		+ "Hospital', 'Mental', '0400-2200', '440 74 114 0000',"
			         		+ " 'Address23')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('123' , 'Kyviv "
			         		+ "Hospital', 'Mental', '0500-2200', '110 74 114 0001',"
			         		+ " 'Address24')");  
		         stmt.executeUpdate("INSERT INTO Healthcare VALUES ('124' , 'Chernobyl "
			         		+ "Hospital', 'Physical', '0300-2300', '200 04 004 7875',"
			         		+ " 'Address25')");  
		         

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
