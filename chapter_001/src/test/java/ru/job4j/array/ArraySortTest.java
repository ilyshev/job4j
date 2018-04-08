package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * тест метода слияния и сортировки массивов
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class ArraySortTest {

    @Test
    public void whenTwoArraysThenThirdSortedArray() {
        ArraySort  testArray = new ArraySort();
        int [] firstArray = {1, 3, 9, 16};
        int[] secondArray = {2, 4, 7};
        int[] result = testArray.ArraySort(firstArray, secondArray);
        int [] expected = {1, 2, 3, 4, 7, 9, 16};
        assertThat(result, is(expected));
    }
}