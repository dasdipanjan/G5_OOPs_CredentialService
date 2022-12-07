package com.glearning.email.interfaces;

import com.glearning.email.model.Employee;

/**
 * This interface is responsible to define all contract related to Credential service based on requirement.
 * 
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-12-2022
 */
public interface ICredentialService {
	String generatePassword();
	String generateEmailAddress(Employee employee);
	void showCredentials(Employee employee);
}
