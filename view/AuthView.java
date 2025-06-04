package view;

import java.util.Map;

public interface AuthView {
	void displayLoginForm();
	void displayRegisterForm();
	Map<String, String> getLoginCredentials();
	Map<String, String> getRegistrationDetails();
	void displayLoginSuccess();
	void displayLoginErrror();
	void displayRegisterSuccess();
	void displayRegisterError(String message);
}