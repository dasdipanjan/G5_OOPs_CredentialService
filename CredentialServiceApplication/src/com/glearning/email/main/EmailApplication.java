package com.glearning.email.main;

import java.util.Scanner;

import com.glearning.email.interfaces.ICredentialService;
import com.glearning.email.model.Employee;
import com.glearning.email.service.CredentialServiceImpl;

/**
 * 
 * This class is the main class of the application. It responsibility is to execute the program.
 * 
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-12-2022
 *
 */
public class EmailApplication {
	
	/**
	 * This is the execution start point of this program. This method is called by main thread of JVM.
	 * 
	 * @param args String array.
	 */
	public static void main(String args[]) {
		EmailApplication application = new EmailApplication();
		Scanner scanner = new Scanner(System.in);
		ICredentialService credentialService = new CredentialServiceImpl("abc.com");
		int option = 0;
		do {	
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			System.out.println("5. Exit");
			System.out.println("Enter Your Option : ");
			option = scanner.nextInt();
			
			switch (option) {
			case 1:
				application.generateEmailAndPassword(scanner, credentialService, "tech");
				break;
			case 2:
				application.generateEmailAndPassword(scanner, credentialService, "admin");
				break;
			case 3:
				application.generateEmailAndPassword(scanner, credentialService, "hr");
				break;
			case 4:
				application.generateEmailAndPassword(scanner, credentialService, "legal");
				break;
			case 5:
				System.out.println("Exiting from Email Application.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option choosen by you.");
				break;
			}
		} while (option != 5);
	}

	private void generateEmailAndPassword(Scanner scanner, ICredentialService credentialService, String department) {
		System.out.println("Enter Your FirstName : ");
		String firstName = scanner.next();
		System.out.println("Enter Your LastName : ");
		String lastName = scanner.next();
		Employee employee = new Employee(firstName, lastName);
		employee.setDepartment(department);
		employee.setEmail(credentialService.generateEmailAddress(employee));
		employee.setPassword(credentialService.generatePassword());
		credentialService.showCredentials(employee);
	}
}
