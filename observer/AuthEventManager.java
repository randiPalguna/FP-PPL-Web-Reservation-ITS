package observer;

import java.util.ArrayList;
import java.util.List;

public class AuthEventManager {
    private static final List<AuthEventListener> listeners = new ArrayList<>();

    public static void addListener(AuthEventListener listener) {
        listeners.add(listener);
    }

    public static void notifyLogin(String email, boolean success) {
        for (AuthEventListener listener : listeners) {
            listener.onLogin(email, success);
        }
    }

    public static void notifyRegister(String email, boolean success) {
        for (AuthEventListener listener : listeners) {
            listener.onRegister(email, success);
        }
    }
}