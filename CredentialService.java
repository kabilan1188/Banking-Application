package service;

import java.util.Random;

import interfaces.ICredentials;
import model.Employee;

public class CredentialService implements ICredentials {
	@Override
	public String generateEmailAddress(String firstName, String lastName, String department) {
		return firstName + lastName + "@" + department + ".abc.com";
	}

	@Override
	public String generatePassword() {
		String password = "";
		String finalPassword = "";
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String specialCharacters = "!@#$%^&*";
		Random random = new Random();

		for (int i = 0; i < 2; i++) {
			int index = random.nextInt(capitalLetters.length());
			char character = capitalLetters.charAt(index);
			password = password + String.valueOf(character);
		}

		for (int i = 0; i < 2; i++) {
			int index = random.nextInt(smallLetters.length());
			char character = smallLetters.charAt(index);
			password = password + String.valueOf(character);
		}

		for (int i = 0; i < 2; i++) {
			int index = random.nextInt(numbers.length());
			char character = numbers.charAt(index);
			password = password + String.valueOf(character);
		}

		for (int i = 0; i < 2; i++) {
			int index = random.nextInt(specialCharacters.length());
			char character = specialCharacters.charAt(index);
			password = password + String.valueOf(character);
		}

		StringBuffer stringBuffer = new StringBuffer(password);

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(stringBuffer.toString().length());
			char character = stringBuffer.toString().charAt(index);
			finalPassword = finalPassword + String.valueOf(character);
		}

		return finalPassword;
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Email --->  " + employee.getEmailID());
		System.out.println("Password ----> " + employee.getPassword());

	}

}
