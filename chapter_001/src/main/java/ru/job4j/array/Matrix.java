package ru.job4j.array;

/**
 * Двухмерный массив. Таблица умножения.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Matrix {
    /**
     * метод реализует таблицу умножения.
     *
     * @param size размер массива.
     * @return массив таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] data = new int[size][size];
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                data[i][j] = i * j;
            }
        }
        return data;
    }
}
