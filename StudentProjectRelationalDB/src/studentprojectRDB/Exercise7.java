/*7.	Display the student information who is a programmer.*/
package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise7 {
	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	

    	  String  selectSql= "SELECT * FROM Student JOIN StudentProject ON Student.st_no = StudentProject.st_no where designation='PROGRAMMER' ; ";
    	  		
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______ student list who is a Programmer______"); 	      
	         while(rs.next()){
	        	 
	        	 //Display values
	        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
	        	 System.out.print("\nName		: " + rs.getString("st_name"));
	        	 System.out.print("\nDate of Birth	: " + rs.getString("st_dob"));
	             System.out.print("\nDate of Join	: " + rs.getString("st_doj"));
	             System.out.print("\nProject No	: " + rs.getString("prj_no"));
	             System.out.print("\ndesignation	: " + rs.getString("designation"));
	             
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

