package ru.job4j.calculate;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */

public class CalculateTest {
    /**
     * Test echo
     */

    @Test
    public void whenTakeNameThenReturnThreeEchoPlusName() {
        String input = "Dmitry Ilyshev";
        String expect = "Echo, echo, echo: Dmitry Ilyshev";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }

}
