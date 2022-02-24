/*8.	Display the student who played the max designation(e.g. manager,programmer) in the same project.*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise8 {
	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	

    	  String  selectSql= "select st_no,prj_no,designation from studentproject where designation = (select max(designation) from studentproject) ";
    	  		
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______ student who played the max designation in the same project______"); 	      
	         while(rs.next()){
	        	 
	        	 //Display values
	        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
	        	 System.out.print("\n\nProject No	: " + rs.getString("prj_no"));
	        	 System.out.print("\n\nDesignation	: " + rs.getString("designation"));
	        
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

