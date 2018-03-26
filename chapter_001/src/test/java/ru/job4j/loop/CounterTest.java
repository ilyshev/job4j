package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Counter - Подсчет четных чисел в диапазоне.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com(.
 * @version $Id$
 */
public class CounterTest {
    /**
     * Сумма четных чисел от 1 до 4 равна 6.
     */
    @Test
    public void whenRangeOneToFourThenSix() {
        Counter count = new Counter();
        int result = count.add(1, 4);
        assertThat(result, is(6));
    }
}