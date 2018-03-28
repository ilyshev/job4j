package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test BubbleSort программы для сортировки массива методом перестановки.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class BubbleSortTest {
    /**
     * если массив 5 1 2 7 3, то после сортировки 1 2 3 5 7
     */
    @Test
    public void whenArray51273ThenSort12357() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[] {5, 1, 2, 7, 3};
        int[] resultArray = bubble.sort(input);
        int[] expectArray = new int[] {1, 2, 3, 5, 7};
        assertThat(resultArray, is(expectArray));
    }
}