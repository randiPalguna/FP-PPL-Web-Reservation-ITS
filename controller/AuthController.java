package controller;

import java.util.Map;
import model.UserModel;
import observer.AuthEventManager;
import view.AuthView;

public class AuthController {
	private AuthView authView;

	public AuthController(AuthView authView) {
		this.authView = authView;
	}

	public void GETLogin() {
		authView.displayLoginForm();
	}

	public void GETRegister() {
		authView.displayRegisterForm();
	}

	public void POSTLogin() {
		Map<String, String> credentials = authView.getLoginCredentials();
		boolean authResult = validateCredentials(credentials);
		// implement design pattern observer
		AuthEventManager.notifyLogin(credentials.get("userEmail"), authResult);
		if (authResult) {
			authView.displayLoginSuccess();
		} else {
			authView.displayLoginErrror();
		}
	}

	public boolean validateCredentials(Map<String, String> credentials) {
		boolean authResult = false;
		
		String userEmail = credentials.get("userEmail");
		String userPassword = credentials.get("userPassword");
		UserModel user = UserModel.getUserModel(userEmail);

		if (user != null && user.login(userEmail, userPassword)) {
			authResult = true;
		}
		return authResult; 
	}

	public void POSTRegister() {
		Map<String, String> details = authView.getRegistrationDetails();
		String userEmail = details.get("userEmail");
		String userName = details.get("userName");
		String userPassword = details.get("userPassword");
		String userNrpOrNip = details.getOrDefault("userNrpOrNip", "");

        if (userEmail == null || userEmail.trim().isEmpty() ||
            userName == null || userName.trim().isEmpty() ||
            userPassword == null || userPassword.isEmpty()) {
            authView.displayRegisterError("Nama, email, and password cannot be empty.");
			// implement design pattern observer
			AuthEventManager.notifyRegister(userEmail, false);
            return;
        }

		if (UserModel.getUserModel(userEmail) != null) {
			authView.displayRegisterError("Email already registered");
			// implement design pattern observer
			AuthEventManager.notifyRegister(userEmail, false);
			return;
		}

		UserModel newUser;
		String userId = "user" + System.currentTimeMillis();
		// newUser = new NonCivitasITS(userId, userName, userEmail, password);
		// implement design pattern factory
		newUser = model.UserFactory.createUser("noncivitas", userId, userName, userEmail, userPassword, userNrpOrNip);
		UserModel.registerUser(userEmail, newUser);

		authView.displayRegisterSuccess();
		// implement design pattern observer
		AuthEventManager.notifyRegister(userEmail, true);
	}
}