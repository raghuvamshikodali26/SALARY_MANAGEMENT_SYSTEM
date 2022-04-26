package salary_management_system.sms_test;


import java.sql.*;
import java.util.Scanner;


public class Emplog {
	private static Connection c =null;
	private static Statement s;
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee User Name");
		String username = sc.nextLine();
		System.out.println("Enter Password");
		long userpassword = sc.nextLong();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/sms";
			String user="root";
			String password="badshah26@KRV";
			c=DriverManager.getConnection(url,user,password);
			s=c.createStatement();
			String q = "Select * from emplogin where user_name = '"+ username +"' and user_password = "+ userpassword;
			Statement st= c.createStatement();
			PreparedStatement pq =c.prepareStatement(q);
			ResultSet res = pq.executeQuery();
			
			
			int count = 0;
		      while (res.next()) {
		        count++;
		      }
			
			
			if(count > 0) {
				System.out.println("Valid Credentials");
				EmployeeLogin.login();
			}
			else {
				System.out.println("Invalid Credentials");
			}
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void EmployeeLogin() {
		// TODO Auto-generated method stub
		
	}
}