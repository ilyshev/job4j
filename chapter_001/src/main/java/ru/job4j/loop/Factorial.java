package ru.job4j.loop;

/**
 * Вычисляем факториал.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Factorial {
    /**
     * Вычислить факториал для n.
     * @param n заданное число.
     * @return факториал заданного n.
     */
    public int calc(int n) {
        int factorial = 1;
        if (n != 0) {
            for (int i = n; i >= 1; i--) {
                factorial *= i;
            }
        }
        return factorial;
    }
}
