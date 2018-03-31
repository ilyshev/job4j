package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

/**
 * Test ArrayDuplicate Удаление дубликатов в массиве.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayDuplicateTest {
    /**
     * если в массиве есть дубликаты, то отрезаем их
     */
    @Test
    public void whenArrayCountainsDupsThenDropThem() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "2", "1", "3", "1"};
        String[] expect = {"1", "2", "3"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}