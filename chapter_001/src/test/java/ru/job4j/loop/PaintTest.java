package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test Piramid7.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class PaintTest {
    /**
     * тестируем правую часть пирамиды.
     */
    @Test
    public void whenPiramidFourRight() {
        Paint paint = new Paint();
        String rst = paint.rightTrg(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^")
                        .toString()
                ));
    }
    /**
     * тестируем левую часть пирамиды.
     */
    @Test
    public void whenPiramidFourLeft() {
        Paint paint = new Paint();
        String rst = paint.leftTrg(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                ));
    }
}