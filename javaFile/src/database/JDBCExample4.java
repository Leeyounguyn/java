//JDBC Print 
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement  stml = null; 
		int r;
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver"); // load drive jDBC connection DB 

			//DB Connect
			connection = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/management", "root", "******"); 
			//How to connect with DB : jdbc: DBName://ip address port number , rootID , pw; 
			
			//select syntax execute
			stml = connection.createStatement();  
			
			
			 System.out.print("(1/2) ID to edit : ");
             String ei = sc.nextLine();
              
             System.out.print("(2/2) Contents to edit (ex : PW='1234', " +
                     "Name ='', Address='2') : ");
             String ev = sc.nextLine();
              
         
             //r = stml.executeUpdate("UPDATE members SET C_PW ='1234'"); Change whole
		    //r = stml.executeUpdate("UPDATE members SET C_PW ='1234' WHERE C_ID = 'Park'");    
			//UPDATE table Name SET  Column Name = value to change condition
			r = stml.executeUpdate("UPDATE members SET C_"+ ev +" WHERE C_ID = '"+ei+"'");  
			
             if( r == 0 ){
                 System.out.println("Could not find what to edit.");
             }else{
                 System.out.println("It is changed. ");
             }

             sc.close();
		
		}catch(ClassNotFoundException | SQLException e){
			System.err.println("Connection Failed. ");
			
		}
	}
}