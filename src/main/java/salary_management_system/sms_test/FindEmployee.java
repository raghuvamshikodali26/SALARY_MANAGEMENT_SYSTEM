package salary_management_system.sms_test;

import java.sql.*;
import java.util.Scanner;


public class FindEmployee extends Jdbc_connection{
	private static Connection c =null;
	private static Statement s;
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/sms";
			String user="root";
			String password="badshah26@KRV";
			c=DriverManager.getConnection(url,user,password);
			s=c.createStatement();
			System.out.println("Please enter value to get your to find employee by using 1)employee ID  2)Employee Name");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				findemployeewithid();
				break;
			case 2:
				findemployeewithname();
				break;
			default:
				System.out.println("please enter correct input");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		

		
	}
	public static void findemployeewithid() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int a=sc.nextInt();
		String sq="Select employee_id, employee_name, employee_designation from employee_details where employee_id = "+a;
		PreparedStatement preparedStatement=c.prepareStatement(sq);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet!=null) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Employee id     |     Employee Name     |     Employee Designation");
			System.out.println("----------------------------------------------------------------------------------");
		}
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("employee_id")+"          "+resultSet.getString("employee_name")+"          "+resultSet.getString("employee_designation"));
			
		}
		System.out.println("----------------------------------------------------------------------------------------");
		
	}
	
	public static void findemployeewithname() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter employee Name");
		String name=sc.nextLine();
		String sq="Select employee_id, employee_name, employee_designation from employee_details where employee_name = '"+name+ "'";
		PreparedStatement preparedStatement=c.prepareStatement(sq);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet!=null) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Employee id     |     Employee Name     |     Employee Designation");
			System.out.println("----------------------------------------------------------------------------------");
		}
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("employee_id")+"          "+resultSet.getString("employee_name")+"          "+resultSet.getString("employee_designation"));
			
		}
		System.out.println("----------------------------------------------------------------------------------------");
		
		
	}
	
	public static boolean emptest(String user, String pass) {
		if(user.equals("admin") && pass.equals("asdfg")) {
			return true;
		}
		else
			return false;
	}
	
}

	

