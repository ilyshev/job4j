package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test Turn Перевернуть массив.
 *
 *@author Dmitry Ilyshev (dilyshev@mac.com).
 *@version $Id$.
 *@since 0.1.
 */
public class TurnTest {
    /**
     * если количество элементов в массиве четное
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4};
        int[] result = turner.turn(input);
        int[] expect = new int[] {4, 3, 2, 1};
        assertThat(result, is(expect));
    }
    /**
     * если количество элементов в массиве НЕчетное
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}