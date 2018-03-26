package ru.job4j.loop;

/**
 * Подсчет суммы четных чисел в диапазоне.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Counter {
    /**
     * метод подсчета суммы четных чисел диапазона.
     * @param start первое число диапазона.
     * @param finish последнее число диапазона.
     * @return sumeven сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sumeven = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sumeven += i;
            }
        }
        return sumeven;
    }
}
