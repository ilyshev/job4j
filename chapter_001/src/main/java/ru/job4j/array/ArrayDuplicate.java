package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов в массиве.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayDuplicate {
    /**
     * метод удаления дубликатов.
     * @param array входной массив.
     * @return массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        //проходим по внешнему массиву
        for (int out = 0; out < unique; out++) {
            //проход по внутреннему, начиная со следующего индекса
            for (int in = out + 1; in < unique; in++) {
                //сравнение рядом стоящих элементов массива
                if (array[out].equals(array[in])) {
                    //группировка дубликатов в конце массива
                    array[in] = array[unique - 1];
                    //уменьшение размера массива на количество дубликатов
                    unique--;
                    in--;
                }
            }
        }
        //возврат методом копирования в новый массив
        // (копирует n элементов исходного массива с начала в новый массив)
        return Arrays.copyOf(array, unique);
    }

}
