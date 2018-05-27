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
     * @param matrix двумерныймассив
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
        if (this.i == matrix.length && this.j == 0) {
            throw new NoSuchElementException("No such element.");
        } else {
            int next = this.matrix[i][j];
            if (this.j == this.matrix[i].length - 1) {
                this.j = 0;
                this.i++;
            } else {
                this.j++;
            }
            return next;
        }
    }
}
