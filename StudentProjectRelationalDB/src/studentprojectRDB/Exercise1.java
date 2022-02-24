/*1.	Display list of all student .*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise1 {

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	
    	  String  selectSql=  "SELECT * FROM Student";
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______Student Details______\n\n"); 	      
	         while(rs.next()){
	            //Display values
	        	 
	            System.out.print("\n\nStudent RollNo	: " + rs.getString("st_no"));
	            System.out.print("\nName	: " + rs.getString("st_name"));
	            System.out.print("\nDate of Birth	: " + rs.getString("st_dob"));
	            System.out.println("\nDate of Join	:' " + rs.getString("st_doj"));
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

