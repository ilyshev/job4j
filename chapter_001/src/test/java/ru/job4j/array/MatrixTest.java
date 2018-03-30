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
     * если размер 3, то таблица умножения 3 на 3 (до 9).
     */

    @Test
    public void whenArraySize3ThenMatrix3x3() {
        Matrix multiTable = new Matrix();
        int size = 3;
        int[][] resultArray = multiTable.multiple(size);
        int[][] expectArray = new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(resultArray, is(expectArray));
    }
    /**
     * если размер 5, то таблица умножения 5 на 5 (до 25).
     */

    @Test
    public void whenArraySize5ThenMatrix5x5() {
        Matrix multiTable = new Matrix();
        int size = 5;
        int[][] resultArray = multiTable.multiple(size);
        int[][] expectArray = new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}, {4, 8, 12, 16, 20}, {5, 10, 15, 20, 25}};
        assertThat(resultArray, is(expectArray));
    }
}
