package ru.job4j.array;

/**
 * программа для сортировки массива методом перестановки.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class BubbleSort {
    /**
     * метод сортировки массива пузырьком.
     * @param array массив.
     * @return массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int swapEl = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swapEl;
                }
            }
        }
        return array;
    }
}
