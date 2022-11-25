package Controller;

import Models.StatusMenu;

public class SingletonStatusMenu {

    private static SingletonStatusMenu instance;
    private StatusMenu currentStatusMenu;

    public static SingletonStatusMenu getInstance() {
        if (instance == null) {
            instance = new SingletonStatusMenu();
        }
        return instance;
    }

    public StatusMenu getcurrentStatusMenu() {
        return currentStatusMenu;
    }

    public void setcurrentMenu(StatusMenu currentStatusMenu) {
        this.currentStatusMenu = currentStatusMenu;
    }

}