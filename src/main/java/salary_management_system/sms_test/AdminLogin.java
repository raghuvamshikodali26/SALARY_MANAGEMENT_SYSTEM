package salary_management_system.sms_test;

import java.sql.*;
import java.util.Scanner;

class AdminLogin extends Jdbc_connection{
	private static Connection c = null;
	private Statement s;
	public static void login() {

		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/sms";
			String user="root";
			String password="badshah26@KRV";
			c=DriverManager.getConnection(url,user,password);
			//s=c.createStatement();
			System.out.println("Please enter from 1-2 for:");
			System.out.println("1. Employee Details  2. Employee Salary Details");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("select option to 1. insert, 2. delete");
				int select1 = sc.nextInt();
				switch(select1) {
				case 1:
					insertRecordInToEmployeeDetails();
					break;
				case 2:
					deleteRecordInEmployeeDetails();
					break;
				default:
					System.out.println("Wrong input");
					
				}
	
		
				
			case 2:
				System.out.println("select option to 1. insert, 2. update, 3. delete");
				int select2 = sc.nextInt();
				switch(select2) {
				case 1:
					insertRecordInToEmployeeSalaryDetails();
					break;
				case 2:
					updateRecordInToEmployeeSalaryDetails();
					break;
				case 3:
					deleteRecordInEmployeeSalaryDetails();
					break;
				default:
					System.out.println("Wrong input");
					
				}
				
				

			
				
			default:
				System.out.println("please enter correct input");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//*********************************************************************************************************************
	
	
	private static void insertRecordInToEmployeeDetails() throws Exception {
		String s1="insert into employee_details values(?,?,?,?)";
		PreparedStatement pre= c.prepareStatement(s1);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Employee ID");
		int emp_id = sc.nextInt();
		pre.setInt(1, emp_id);
		System.out.println();
		sc.nextLine();
		
		System.out.println("Employee Name");
		String emp_name = sc.nextLine();
		pre.setString(2, emp_name);
		
		System.out.println();
		
		System.out.println("Employee Designation");
		String emp_desig = sc.nextLine();
		pre.setString(3, emp_desig);
		
		System.out.println();
	
		
		System.out.println("Employee Gender");
		String emp_gender = sc.nextLine();
		pre.setString(4, emp_gender);
		
		System.out.println();
		
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Employee Record inserted succesfully");
		}
		
	}
	
	
	//*********************************************************************************************************************
	
	
	
	private static void insertRecordInToEmployeeSalaryDetails() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		String s1="insert into employee_salary_details values(?,?,?,?,?,?,?)";
		PreparedStatement pre= c.prepareStatement(s1);
		
		System.out.println("Employee ID");
		int emp_id = sc.nextInt();
		pre.setInt(1, emp_id);
		
		
		System.out.println("Employee Level(1,2,3,4)");
		int emp_level = sc.nextInt();
		pre.setInt(2, emp_level);
		
		
		System.out.println("Number of working days in month");
		int daysInMonth = sc.nextInt();
		pre.setInt(3,daysInMonth);
		
		System.out.println("Employee's Attendance in that month");
		int emp_attend = sc.nextInt();
		pre.setInt(4, emp_attend);
		
		System.out.println("Employee's basic salary per month");
		double emp_basicsalary_permonth = sc.nextDouble();
		pre.setDouble(5, emp_basicsalary_permonth);
		
		double hra = emp_basicsalary_permonth*0.075;
		
		pre.setDouble(6, hra);
		
		double total = emp_basicsalary_permonth + hra;
		
		pre.setDouble(7, total);
		
	
		
		
		
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Employee salary record inserted succesfully");
		}
	}



	//*********************************************************************************************************************
	
	
	
	
	private static void updateRecordInToEmployeeSalaryDetails() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int emp_id = sc.nextInt();
		System.out.println("Enter employee new level");
		int emp_level = sc.nextInt();
		String sq1="update employee_salary_details set employee_work_level="+emp_level+" where employee_id = "+emp_id;
		PreparedStatement pq =c.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record updated succesfully");
		}
		String sq="select * from employee_salary_details";
		Statement st= c.createStatement();
		ResultSet rt=st.executeQuery(sq);

		
	}
	


	//*********************************************************************************************************************
	
	private static void deleteRecordInEmployeeDetails() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id that you want to delete");
		int emp_id = sc.nextInt();

		
		
		String sq1="delete from employee_details where employee_id="+emp_id;
		PreparedStatement pq =c.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record deleted succesfully");
		}
		String sq="select * from employee_details";
		Statement st= c.createStatement();
		ResultSet rt=st.executeQuery(sq);
		while(rt.next()) {
			String employee_name = rt.getString("employee_name");
			System.out.println(employee_name);
	
		}
		
	}
	
	
	
	//*********************************************************************************************************************
	
	private static void deleteRecordInEmployeeSalaryDetails() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id that you want to delete");
		int emp_id = sc.nextInt();
		
		
		String sq1="delete from employee_salary_details where employee_id="+emp_id;
		PreparedStatement pq =c.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record deleted succesfully");
		}
		String sq="select * from employee_salary_details";
		Statement st= c.createStatement();
		ResultSet rt=st.executeQuery(sq);
		while(rt.next()) {
			String employee_id = rt.getString("employee_id");
			System.out.println(employee_id);
	
		}
		
	}
	
	//************************************************************************************************************************
}


