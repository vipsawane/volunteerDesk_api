package net.odk.volunteerdesk_api.models;

public class ResponseAuth {
    private boolean success;
    private Object user; // Peut être soit User soit Organisation
    private String message;

    // Constructeurs
    public ResponseAuth(boolean success, Object user) {
        this.success = success;
        this.user = user;
    }

    public ResponseAuth(boolean success, Object user, String message) {
        this.success = success;
        this.user = user;
        this.message = message;
    }

    public ResponseAuth(boolean success, User user, Role role) {
    }

    // Getters et Setters
    public boolean isSuccess() {
        return success;
    }

    public Object getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAuthenticated() {

        return false;
    }

    public Object getErrorMessage() {
        return "Donnée de connexion incorrecte";
    }
}
