package main;

import java.util.Scanner;

import interfaces.ICredentials;
import model.Employee;
import service.CredentialService;

public class DriverClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the first name: ");
		String fName = scanner.nextLine();
		String firstName = fName.toLowerCase();

		System.out.print("Enter the last name: ");
		String lName = scanner.nextLine();
		String lastName = lName.toLowerCase();
		
		ICredentials iCredentials = new CredentialService();		
		int option;
		int flag = 0;
		String department = "";
		String generateEmailID = "";
		String generatePassword = "";

		do {
			System.out.println("Please enter the department from the following");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				department = "tech";
				generateEmailID = iCredentials.generateEmailAddress(firstName, lastName, department);
				generatePassword = iCredentials.generatePassword();
				flag = 1;
				break;
			case 2:
				department = "admin";
				generateEmailID = iCredentials.generateEmailAddress(firstName, lastName, department);
				generatePassword = iCredentials.generatePassword();
				flag = 1;
				break;
			case 3:
				department = "hr";
				generateEmailID = iCredentials.generateEmailAddress(firstName, lastName, department);
				generatePassword = iCredentials.generatePassword();
				flag = 1;
				break;
			case 4:
				department = "legal";
				generateEmailID = iCredentials.generateEmailAddress(firstName, lastName, department);
				generatePassword = iCredentials.generatePassword();
				flag = 1;
				break;
			default:
				System.out.println("Invalid option");
				flag = 0;
			}
		} while (flag == 0);

		Employee employee = new Employee(firstName, lastName, department);
		employee.setEmailID(generateEmailID);
		employee.setPassword(generatePassword);

		System.out.println("Dear " + fName + " your generated credentials are as follows");
		iCredentials.showCredentials(employee);
	}

}
