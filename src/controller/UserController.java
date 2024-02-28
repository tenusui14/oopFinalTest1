package controller;

import model.ComplexNumber;
import model.util.Calculable;
import model.util.Operators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserController {

    private final Calculable calculator;
    private final List<String> validOperators;

    public UserController(Calculable calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());;
    }

    public String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    public ComplexNumber initiateNumber(String message){
        System.out.println(message);
        String firstPart = prompt("Введите вещественную часть комплексного числа: ");
        String secondPart = prompt("Введите мнимую часть комплексного числа: ");

        double first = Double.parseDouble(firstPart);
        double second = Double.parseDouble(secondPart);

        return new ComplexNumber(first,second);
    }


    private boolean isInvalidOperator(String operator){
        return !validOperators.contains(operator);
    }

    public String getOperator(){
        String operator = prompt("Введите математическую операцию (+ , * , / ) : ");
        while(true){
            if(isInvalidOperator(operator)){
                System.err.println("Введен неизвестный оператор. ");
                operator = prompt("Введите математическую операцию (+ , * , / ) :");
            } else return operator;
        }
    }

    public void prepare(){
        ComplexNumber a = initiateNumber("Первое комплексное число: ");
        String operator = getOperator();
        ComplexNumber b = initiateNumber("Второе комплескное число: ");
        if(operator.equals("*")){
            calculator.multiply(a,b);
        }
        if(operator.equals("+")){
            calculator.sum(a,b);
        }
        if(operator.equals("/")){
            calculator.divide(a,b);
        }

        System.out.println(calculator.calculationResult());
        calculator.clear();
    }
}
