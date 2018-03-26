package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Max - выбираем максимальное число
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */

public class MaxTest {
    /**
     * Если первое число меньше второго, выбираем второе
     */
    @Test
    public void whenFirstLessSecondThenSecond() {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Максимум из трех чисел.
     * Если первое число больше второго и третьего, то выбираем первое.
     */
    @Test
    public void whenFirstMoreThanSecondAndThirdThenFirst() {
        Max maxThree = new Max();
        int result = maxThree.max(6, 4, 2);
        assertThat(result, is(6));
    }
}