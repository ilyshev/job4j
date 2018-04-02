package ru.job4j.array;

/**
 *Перевернуть массив.
 *
 *@author Dmitry Ilyshev (dilyshev@mac.com).
 *@version $Id$.
 *@since 0.1.
 */
public class Turn {
    public int[] turn(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int swapElement = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = swapElement;
        }
        return array;
    }
}
