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
        //идем с начала массива
        for (int i = 0; i < array.length; i++) {
            //сокращаем фрагмент массива
            for (int j = array.length - 1; j > i; j--) {
                //сравненение элементов массива парами
                if (array[j] < array[j - 1]) {
                    //меняем элементы массива местами
                    int swapEl = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swapEl;
                }
            }
        }
        return array;
    }
}
