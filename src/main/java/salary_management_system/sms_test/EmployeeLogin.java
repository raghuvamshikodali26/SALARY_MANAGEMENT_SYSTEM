package salary_management_system.sms_test;

import java.sql.*;
import java.util.Scanner;


public class EmployeeLogin extends Jdbc_connection{
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
			System.out.println("Please enter 1 to get your payslips");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				payslips();
				break;
			default:
				System.out.println("please enter correct input");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		

		
	}
	public static void payslips() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int a=sc.nextInt();
		String sq="Select employee_details.employee_name, employee_details.employee_id, employee_details.employee_designation, employee_salary_details.actual_salary, employee_salary_details.hra, employee_salary_details.take_home_salary from employee_details join employee_salary_details where employee_details.employee_id = "+a + " and employee_salary_details.employee_id="+a;
		PreparedStatement preparedStatement=c.prepareStatement(sq);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet!=null) {
			System.out.println("                                  Revature India                         ");
			System.out.println("                                  Chennai, India                         ");
			
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.println("Employee id|Employee Name |Employee Designation     |Employee Basic Salary|  HRA       | Net Salary" );
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
		}
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("employee_details.employee_id")+"          "+resultSet.getString("employee_details.employee_name")+"          "+resultSet.getString("employee_details.employee_designation")+"          "+resultSet.getDouble("employee_salary_details.actual_salary")+"          "+resultSet.getDouble("employee_salary_details.hra")+"          "+resultSet.getDouble("employee_salary_details.take_home_salary"));
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		
		
	}
	
}

	

