package model;

import model.util.Calculable;

public class Logger  implements Calculable {
    private Calculable calculate;

    public Logger(Calculable calculate) {
        this.calculate = calculate;
    }

    @Override
    public void sum(ComplexNumber a, ComplexNumber b) {
        System.out.printf("Cуммирую: (%s) + (%s) = ", a,b);
        calculate.sum(a,b);

    }

    @Override
    public void multiply(ComplexNumber a, ComplexNumber b) {
        System.out.printf("Умножаю: (%s) * (%s) = ",a,b);
        calculate.multiply(a,b);

    }

    @Override
    public void divide(ComplexNumber a, ComplexNumber b) {
        System.out.printf("Делю: (%s) / (%s) = ", a,b);
        calculate.divide(a,b);

    }

    @Override
    public ComplexNumber calculationResult() {
        return calculate.calculationResult();
    }

    @Override
    public ComplexNumber clear() {
        return calculate.clear();
    }
}
