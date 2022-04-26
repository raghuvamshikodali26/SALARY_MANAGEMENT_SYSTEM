package salary_management_system.sms_test;
import java.sql.*;
import java.util.Scanner;


public class Adlog {
	private static Connection c =null;
	private static Statement s;
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee User Name");
		String username = sc.nextLine();
		System.out.println("Enter Password");
		long user_password = sc.nextLong();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/sms";
			String user="root";
			String password="badshah26@KRV";
			c=DriverManager.getConnection(url,user,password);
			s=c.createStatement();
			String q = "Select * from adminlog where user_name = '"+ username +"' and user_password = "+ user_password;
			Statement st= c.createStatement();
			PreparedStatement pq =c.prepareStatement(q);
			ResultSet res = pq.executeQuery(q);
			
			int count = 0;
		      while (res.next()) {
		        count++;
		      }
			
			
			if(count > 0) {
				System.out.println("Welcome Admin");
				AdminLogin.login();
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
	
}