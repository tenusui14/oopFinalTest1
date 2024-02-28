package view;

import controller.UserController;

import java.util.Scanner;

public class View {
    private final UserController userController;

    public View(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        while(true) {
            userController.prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.out.println("Продолжить?... (y/n)");
        return in.nextLine();
    }
}
