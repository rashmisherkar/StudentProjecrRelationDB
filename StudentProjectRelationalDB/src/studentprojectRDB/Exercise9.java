/*9.	Display details of the youngest student.*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise9 {

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	

    	  String  selectSql= "select st_name ,st_dob from student  where st_dob = (select max(st_dob) from student)";
    	  		
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______ Details of the youngest student______"); 	      
	         while(rs.next()){
	        	 
	        	 //Display values
	        	 System.out.print("\nName	        : " + rs.getString("st_name"));
	        	 System.out.print("\n\nStudent DOB	: " + rs.getString("st_dob"));
	        	
	        
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

