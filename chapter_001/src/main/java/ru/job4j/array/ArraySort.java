package ru.job4j.array;

/**
 * Слияние двух массивов в третий и сортировка.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $iD$
 * @since 0.1
 */
public class ArraySort {
    /**
     * Метод слияния двух массивов.
     * @param first первый массив
     * @param second второй массив
     */
    public int[] arraySort(int[] first, int[] second) {
        /**
         * Результирующий массив.
         */
        int[] array = new int[first.length + second.length];
        /**
         * Собираем третий массив из двух.
         */
        for (int i = 0, p = 0; i < array.length; i++, p++) {
            if (i == first.length) {
                p = 0;
            }
            if (i < first.length) {
                array[i] = first[p];
            } else {
                array[i] = second[p];
            }
        }
        /**
         * Сортируем массив методом пузырька BubbleSort.
         */
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
