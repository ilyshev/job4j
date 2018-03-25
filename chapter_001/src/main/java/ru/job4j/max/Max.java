package ru.job4j.max;

/**
 * Максимум из двух чисел.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Max {
    /**
     * Сравнение двух чисел и выбор максимального
     * @param first первое число
     * @param second второе число
     * @return максимальное
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
