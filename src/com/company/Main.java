package com.company;

import java.util.Scanner;

public class Main {
    private static String calc(String input)  throws CalculatorExceptions{
        String[] expression = input.split(" ");
        if (expression.length != 3) {
            throw new CalculatorExceptions("Формат не соответствует условию задания(a + b, a - b, a * b, a / b)");
        }
        Roman[] roman = Roman.values();
        String num1 = expression[0];
        String num2 = expression[2];
        int result;
        String total;
        char op = expression[1].charAt(0);
        if (isRoman(num1) & isRoman(num2)) {
            int n1 = Roman.valueOf(num1).getConvert();
            int n2 = Roman.valueOf(num2).getConvert();
            if (n1 >= 1 & n1 <= 10 & n2 >= 1 & n2 <= 10) {
                result = calculation(n1, op, n2);
                if (result >= 1) {
                    int lastresult = result - 1;
                    total = String.valueOf(roman[lastresult]);
                    return total;
                } else {
                    throw new CalculatorExceptions("Результатом работы калькулятора с римскими числами могут быть только положительные числа!");
                }
            } else {
                throw new CalculatorExceptions("Калькулятор принимает на вход числа от 1 до 10!");
            }
        }
        else if (isArabian(num1) & isArabian(num2)) {
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            if (n1 >= 1 & n1 <= 10 & n2 >= 1 & n2 <= 10) {
                result = calculation(n1, op, n2);
                total = String.valueOf(result);
                return total;
            } else {
                throw new CalculatorExceptions("Калькулятор принимает на вход числа от 1 до 10!");
            }
        }
        else if ((isRoman(num1) & isArabian(num2)) | (isArabian(num1) & isRoman(num2))) {
            throw new CalculatorExceptions("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно!");
        }
        else {
            throw new CalculatorExceptions("Строка не соответствует математической операции");
        }
    }

    public static void main(String[] args) throws CalculatorExceptions {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Итог: " + calc(input));
    }

    private static boolean isArabian(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isRoman(String number) {
        Roman[] roman = Roman.values();
        for (Roman value : roman) {
            if (number.equals(String.valueOf(value))) {
                return true;
            }
        }
        return false;
    }

    private static int calculation(int n1, char op, int n2)  throws CalculatorExceptions{
        int results;
        switch (op) {
            case '+' -> results = (n1 + n2);
            case '-' -> results = (n1 - n2);
            case '*' -> results = (n1 * n2);
            case '/' -> results = (n1 / n2);
            default -> throw new CalculatorExceptions("Введена неверная операция, допускаются (+, -, *, /)");
        }
        return results;
    }
}
