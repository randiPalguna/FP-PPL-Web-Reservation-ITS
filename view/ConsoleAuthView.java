package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleAuthView implements AuthView {
	private Scanner scanner;

	public ConsoleAuthView(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void displayLoginForm() {
		System.out.println("\n-- Login Form --");
	}

	@Override
	public void displayRegisterForm() {
		System.out.println("\n--  Registration Form (Non-Civitas ITS) ---");
	}

	@Override
	public Map<String, String> getLoginCredentials() {
		Map<String, String> credentials = new HashMap<>();
		System.out.print("Enter email: ");
		credentials.put("userEmail", scanner.nextLine());
		System.out.print("Enter password: ");
		credentials.put("userPassword", scanner.nextLine());
		return credentials;
	}

	@Override
	public Map<String, String> getRegistrationDetails() {
		Map<String, String> details = new HashMap<>();
		System.out.print("Enter nama: ");
		details.put("userName", scanner.nextLine());
		System.out.print("Enter email: ");
		details.put("userEmail", scanner.nextLine());
		System.out.print("Enter password: ");
		details.put("userPassword", scanner.nextLine());
		return details;
	}

	@Override
	public void displayLoginSuccess() {
		System.out.println("Login successful!");
	}

	@Override
	public void displayLoginErrror() {
		System.out.println("Login failed. Please check your email and password.");
	}

	@Override
	public void displayRegisterSuccess() {
		System.out.println("Registration successful!");
	}

	@Override
	public void displayRegisterError(String message) {
		System.out.println("Registration failed: " + message);
	}
}