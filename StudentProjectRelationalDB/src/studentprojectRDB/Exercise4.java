/*4.	Display number of students who participated in more than one project.*/

package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise4 {

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	
    	  String  selectSql=  "select st_no, count(st_no) from StudentProject group by st_no having count(prj_no) > 1;";
    	  		
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______ Number of students who participated in more than one project______"); 	      
	         while(rs.next()){
	            //Display values
	        	 
	        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
	             System.out.print("\n participated in project count	: " + rs.getString("count(st_no)"));
	             
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

