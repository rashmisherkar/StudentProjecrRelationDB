/*3.	Display the number of students who are working on project “P01”.*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise3 {
	

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	
    	  String  selectSql=  "SELECT count(st_no) from studentproject where prj_no='P01';";
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______Number of students who are working on project “P01”______"); 	      
	         while(rs.next()){
	            //Display values
	        	 
	        	 System.out.print("\n\nStudent No	: " + rs.getString("count(st_no)"));
	         }
	         conn.close();
	       }catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

