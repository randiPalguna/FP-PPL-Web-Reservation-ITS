package model;

public class NonCivitasITS extends UserModel {
	public NonCivitasITS(String userId, String userName, String userEmail, String plainPassword) {
		super(userId, userName, userEmail);
		this.setPasswordHash(plainPassword);
	}
}