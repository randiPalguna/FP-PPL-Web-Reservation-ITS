package model;

import java.util.HashMap;

public abstract class UserModel {
	protected String userId;
	protected String userName;
	protected String userEmail;
	protected String passwordHash;
	protected static HashMap<String, UserModel> registeredUsers = new HashMap<String, UserModel>();

	public UserModel(String userId, String userName, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public String getuserName() {
		return userName;
	}

	public String getEmail() {
		return userEmail;
	}

	public boolean login(String email, String password) {
		return this.userEmail.equals(email) &&
			   this.passwordHash != null &&
			   this.passwordHash.equals(password + "_hashed");
	}

	protected void setPasswordHash(String plainPassword) {
		this.passwordHash = plainPassword + "_hashed";
	}

	public static UserModel getUserModel(String userEmail) {
		return registeredUsers.get(userEmail);
	}

	public static void registerUser(String userEmail, UserModel user) {
		registeredUsers.put(userEmail, user);
	}
}