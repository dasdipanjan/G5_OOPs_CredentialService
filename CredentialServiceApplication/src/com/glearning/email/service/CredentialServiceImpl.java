package com.glearning.email.service;

import java.util.Random;

import com.glearning.email.interfaces.ICredentialService;
import com.glearning.email.model.Employee;

/**
 * This is an implementation of ICredentialService interface. This is responsible to provide method to generate
 * email address, generate password and print employee credential and email id details.
 * 
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-12-2022
 */
public class CredentialServiceImpl implements ICredentialService {
	private String companyName;

	public CredentialServiceImpl(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * This method is responsible to generate random alpha numeric password.
	 */
	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrst";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*_=+-/.?<>";
		String values = capitalLetters.concat(smallLetters).concat(specialCharacters).concat(numbers);
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<10; i++) {
			buffer.append(values.charAt(random.nextInt(values.length())));
		}
		return buffer.toString();
	}
	
	/**
	 * This method is responsible to generate employee's email id based on first name and last name and department type.
	 * 
	 * @param employee Object of {@link Employee} class.
	 */
	@Override
	public String generateEmailAddress(Employee employee) {
		if (employee != null && ((employee.getFirstName() != null && !employee.getFirstName().isEmpty())
				|| employee.getLastName() != null && !employee.getLastName().isEmpty())) {
			return employee.getFirstName()
					.concat(employee.getFirstName())
					.concat("@")
					.concat(employee.getDepartment())
					.concat(".")
					.concat(companyName);
		} else {
			System.out.println("Unable to create email adderss as firstName and lastName is either null or empty.");
		}
		return null;
	}

	/**
	 * This method is responsible to print employee's email id and generated password.
	 * 
	 * @param employee Object of {@link Employee} class.
	 */
	@Override
	public void showCredentials(Employee employee) {
		System.out.println("\n\n-----Employee's Credential Details------");
		if (employee != null) {
			if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
				System.out.println("Email Id : " + employee.getEmail());
			}
			if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
				System.out.println("Password : " + employee.getPassword());
			}
		}
		System.out.println("-------------------------------------\n\n");
	}
}
