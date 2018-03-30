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
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = (i + 1) * (j + 1);
            }
        }
        return data;
    }
}
