package model.util;

import model.ComplexNumber;

public interface Calculable {
    void sum(ComplexNumber a, ComplexNumber b);
    void multiply(ComplexNumber a, ComplexNumber b);
    void divide(ComplexNumber a, ComplexNumber b);
    ComplexNumber calculationResult();
    ComplexNumber clear();
}
