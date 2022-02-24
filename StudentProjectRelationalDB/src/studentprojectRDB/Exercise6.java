/*6.	Display the information (no,name,age) of student  who made the project in java.*/
package studentprojectRDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise6 {

	static final String DB_URL = "jdbc:mysql://localhost/Student_Project_relational";
	static final String USER = "root";
	static final String PASS = "Atkar@2021";
	 
 public static void main(String[] args) throws SQLException {
	
	 
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 Statement stmt = conn.createStatement();
	
      try{	

    	  String  selectSql= "SELECT DISTINCT "
    		   		+ "student.st_no,\r\n"
    		   		+ "  student.st_name,\r\n"
    		   		+ "  project.prj_platform,\r\n"
    		   		+ "TIMESTAMPDIFF(YEAR,student.st_dob, CURDATE()) AS age \r\n"
    		   		+ "FROM Student \r\n"
    		   		+ "JOIN StudentProject\r\n"
    		   		+ "  ON Student.st_no = StudentProject.st_no \r\n"
    		   		+ "JOIN Project\r\n"
    		   		+ "  ON Project.prj_no = StudentProject.prj_no where prj_platform='JAVA' ; ";
    	  		
		   stmt = conn.createStatement();	//
		   ResultSet rs = stmt.executeQuery( selectSql);
		   System.out.println("\n\n______ student list who made the project in java______"); 	      
	         while(rs.next()){
	        	 
	        	 //Display values
	        	 System.out.print("\n\nStudent No	: " + rs.getString("st_no"));
	        	 System.out.print("\nName	        : " + rs.getString("st_name"));
	        	 System.out.print("\nage             : " + rs.getString("age"));
	        	 System.out.println("\nPlatform  	: " + rs.getString("prj_platform"));
	             
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}

