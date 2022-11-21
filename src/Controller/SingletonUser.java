package Controller;

import Models.User;

public class SingletonUser {

    private static SingletonUser instance;
    private User currentUser;

    public static SingletonUser getInstance() {
        if (instance == null) {
            instance = new SingletonUser();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}
