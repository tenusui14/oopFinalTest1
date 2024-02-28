import controller.UserController;
import model.Calculator;
import model.ComplexNumber;
import model.Logger;
import view.View;

public class Main {
    public static void main(String[] args) {

//        View view = new View(new UserController(new Calculator()));
//        view.run();

        View view = new View(new UserController(new Logger(new Calculator())));
        view.run();
    }

}