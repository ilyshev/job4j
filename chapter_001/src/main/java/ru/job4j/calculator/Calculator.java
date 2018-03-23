package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */

public class Calculator {
    /**
     * задаем переменную result
     */
    private double result;

    /**
     * метод сложения add.
     * @param first - first
     * @param second - second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * метод вычитания substract.
     * @param first - first
     * @param second - second
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * метод деления div
     * @param first - first
     * @param second - second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * метод умножения multiple
     * @param first - first
     * @param second - second
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * вывод результата
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
