package model;

public class UserFactory {
    public static UserModel createUser(String type, String userId, String userName, String userEmail, String userPassword, String userNrpOrNip) {
        if ("civitas".equalsIgnoreCase(type)) {
            return new CivitasITS(userId, userName, userEmail, userNrpOrNip, userPassword);
        } else if ("noncivitas".equalsIgnoreCase(type)) {
            return new NonCivitasITS(userId, userName, userEmail, userPassword);
        }
        return null;
    }
}