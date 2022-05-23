package com.company;

public class CalculatorExceptions extends Exception {
    public CalculatorExceptions() {
        System.out.println("Введено неверные данные");
    }

    public CalculatorExceptions(String exception) {
        System.out.println(exception);
    }

}
