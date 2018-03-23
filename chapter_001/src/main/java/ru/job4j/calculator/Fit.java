package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Fit {
    /**
     * Вычисляем идеальный вес мужчины.
     * @param height рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Вычисляем идеальный вес женщины.
     * @param height рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}

