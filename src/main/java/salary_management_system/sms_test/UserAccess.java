package salary_management_system.sms_test;

import java.util.*;

class Login{
	private static Scanner sc = new Scanner(System.in);
	static void login() {
		
		
		int user = sc.nextInt();
		switch(user) {
		case 1:
			Adlog.login();
			break;
		case 2:
			Emplog.login();
			break;
		case 3:
			FindEmployee.login();
//			break;
			;
		default:
	
			System.out.println("Unauthorized user");
		
		}
	}
}


public class UserAccess {

	public static void main(String[] args) {
		System.out.println("Please select user access option. 1) admin. 2) employee. 3) find employee");
		Login login =new Login();
		login.login();

	}

//	public static void login() {
//		// TODO Auto-generated method stub
//		
//	}

}
