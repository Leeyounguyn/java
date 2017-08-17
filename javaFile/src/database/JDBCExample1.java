//JDBC Print 
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement  stml = null; 
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver"); // load drive jDBC connection DB 

			//DB Connect
			connection = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/management", "root", "1234"); 
			//How to connect with DB : jdbc: DBName://ip address port number , rootID , pw; 
			
			//select syntax execute
			stml = connection.createStatement();  

			ResultSet rs = stml.executeQuery("select C_ID, C_PW, C_Name, C_Address from members");
			
				System.out.println("ID      PW          Name      Address");
				System.out.println("======================================================");
				//Execute the result of select syntax 
				while(rs.next()){
					String b_ID    = rs.getString("C_ID");
					String b_Pw    = rs.getString("C_PW");
					String b_Name  = rs.getString("C_Name");
					String b_address = rs.getString("C_Address");
				
					System.out.printf("%s    %6s    %5s       %5s\n", b_ID, b_Pw, b_Name, b_address);	
					
				}
		
		}catch(ClassNotFoundException | SQLException e){
			System.err.println("Connection Failed. ");
			
		}
	}
}