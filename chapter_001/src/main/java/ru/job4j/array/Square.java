package ru.job4j.array;

/**
 *Заполнить массив степенями чисел.
 *@author Dmitry Ilyshev (dilyshev@mac.com).
 *@version $Id$.
 *@since 0.1.
 */

public class Square {
    /**
     * Метод возведения в квадрат
     * @param bound размер массива
     * @return rst массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        //заполнить массив через цикл элементами от 1 до bound, возведенными в квадрат
        for (int index = 0; index < rst.length; index++) {
            rst[index] = (int) Math.pow((index + 1), 2);
        }
        return rst;
    }
}