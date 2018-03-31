package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test ArrayChar
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayCharTest {
    /**
     * если начало совпадает с префиксом, то возвращает true
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startsWith("He");
        assertThat(result, is(true));
    }
    /**
     * если начало не совпадает с префиксом, то возвращает false
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startsWith("Hi");
        assertThat(result, is(false));
    }
}