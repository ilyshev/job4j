package ru.job4j.array;

/**
 *Классический поиск перебором.
 *
 *@author Dmitry Ilyshev (dilyshev@mac.com).
 *@version $Id$.
 *@since 0.1.
 */

public class FindLoop {
    /**
     * Метод поиска элемента массива.
     * @param data массив.
     * @param el искомый элемент.
     * @return rst индекс искомого элемента массива.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
