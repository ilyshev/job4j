package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс итератор для двумерного массива int[][]
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version 0.1
 * @since 21/05/2018
 */
public class MatrixIterator implements Iterator {

    private final int[][] matrix;
    private int i = 0;
    private int j = 0;

    /**
     * конструктор класса.
     * @param matrix двумерный массив
     */
    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }


    @Override
    public boolean hasNext() {
        return this.i < this.matrix.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No such element.");
        }
        int next = this.matrix[i][j++];
        if (this.matrix[i].length == this.j) {
            this.j = 0;
            this.i++;
        }
        return next;
    }
}
