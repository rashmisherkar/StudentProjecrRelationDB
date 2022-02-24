/*2.	Display list of all projects.*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise2 {

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	
    	  String  selectSql=  "SELECT * FROM project";
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______Project Details______\n\n"); 	      
	         while(rs.next()){
	            //Display values
	        	 
	        	 System.out.print("\n\nProject No	: " + rs.getString("prj_no"));
	             System.out.print("\n  Project Name	: " + rs.getString("prj_name"));
	             System.out.print("\n Project Duration	: " + rs.getInt("prj_dur"));
	             System.out.println("\nPlatform	:' " + rs.getString("prj_platform"));
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

