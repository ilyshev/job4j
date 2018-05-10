package ru.job4j.list;

import java.util.List;

/**
 * конвертация ArrayList в двумерный массив
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since  0.1
 */
public class ConvertList2Array {
    /**
     * Метод конвертации листа записей в двумерный массив.
     * @param list начальный список.
     * @param rows количество строк в массиве.
     * @return двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer value : list) {
            array[i][j] = value;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}
