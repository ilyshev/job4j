package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Converter Test.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1
 */

public class ConverterTest {
    /**
     * test rub2doll
     */
    @Test
    public void when60RubToDollThen1() {
        Converter converter = new Converter();
        int result = converter.rubToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * test rub2euro
     */
    @Test
    public void when70RubToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * test doll2rub
     */
    @Test
    public void when1DollToRubThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRub(1);
        assertThat(result, is(60));
    }

    /**
     * test euro2rub
     */
    @Test
    public void when1EuroToRubThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRub(1);
        assertThat(result, is(70));
    }
}