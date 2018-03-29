package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Matrix Двухмерный массив. Таблица умножения.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */

public class MatrixTest {
    /**
     * если размер 3, то таблица умножения 2 на 2 (до 4).
     */

    @Test
    public void whenArraySize3ThenMatrix2x2() {
        Matrix multiTable = new Matrix();
        int size = 3;
        int[][] resultArray = multiTable.multiple(size);
        int[][] expectArray = new int[][]{{0, 0, 0}, {0, 1, 2}, {0, 2, 4}};
        assertThat(resultArray, is(expectArray));
    }
    /**
     * если размер 5, то таблица умножения 4 на 4 (до 16).
     */

    @Test
    public void whenArraySize5ThenMatrix4x4() {
        Matrix multiTable = new Matrix();
        int size = 5;
        int[][] resultArray = multiTable.multiple(size);
        int[][] expectArray = new int[][]{{0, 0, 0, 0, 0}, {0, 1, 2, 3, 4}, {0, 2, 4, 6, 8}, {0, 3, 6, 9, 12}, {0, 4, 8, 12, 16}};
        assertThat(resultArray, is(expectArray));
    }
}
