package model;

import model.util.Calculable;

public class Calculator implements Calculable {

    private ComplexNumber result;
    private double firstPart;
    private double secondPart;

    public Calculator() {
        new ComplexNumber(0, 0);
    }

    @Override
    public void sum(ComplexNumber a, ComplexNumber b) {
        firstPart = a.getA() + b.getA();
        secondPart = a.getB() + b.getB();
        result = new ComplexNumber(firstPart, secondPart);

    }

    @Override
    public void multiply(ComplexNumber a, ComplexNumber b) {
        firstPart = (a.getA() * b.getA()) - (a.getB() * b.getB());
        secondPart = (a.getA() * b.getB()) + (a.getB() * b.getA());
        result = new ComplexNumber(firstPart, secondPart);
    }

    @Override
    public void divide(ComplexNumber a, ComplexNumber b) {
        try {
            firstPart = (a.getA() * b.getA() + a.getB() * b.getB()) / (b.getA() * b.getA() + b.getB() * b.getB());
            secondPart = (a.getB() * b.getA() - a.getA() * b.getB()) / (b.getA() * b.getA() + b.getB() * b.getB());
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by zero exception");
        }
        result = new ComplexNumber(firstPart, secondPart);

    }

    @Override
    public ComplexNumber calculationResult() {
        return this.result;
    }

    @Override
    public ComplexNumber clear() {
       return this.result = new ComplexNumber(0, 0);
    }
}
