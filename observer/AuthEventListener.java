package observer;

public interface AuthEventListener {
    void onLogin(String email, boolean success);
    void onRegister(String email, boolean success);
}