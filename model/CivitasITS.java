package model;

public class CivitasITS extends UserModel {
	private String userNrpOrNip;

	public CivitasITS(String userId, String userName, String userEmail, String userNrpOrNip, String plainPassword) {
		super(userId, userName, userEmail);
		this.userNrpOrNip = userNrpOrNip;
		this.setPasswordHash(plainPassword);
	}

	public String getUserNrpOrNip() {
		return userNrpOrNip;
	}

	public void setNrpOrNip(String userNrpOrNip) {
		this.userNrpOrNip = userNrpOrNip;
	}
}