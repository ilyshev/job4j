package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест конвертации двумерного массива в List
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since  0.1
 */
public class ConvertMatrix2ListTest {
    /**
     * если массив 2 на 2, то лист от 1 до 4
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = list.toList(input);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        assertThat(result, is(expect));
    }
}