package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator Test.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * test add.
     */
  @Test
    public void whenAddOnePlusOneThenTwo() {
     Calculator calc = new Calculator();
     calc.add(1D, 1D);
     double result = calc.getResult();
     double expected = 2D;
     assertThat(result, is(expected));
  }
    /**
     * test substract.
     */
  @Test
    public void whenSubstractTwoOnOneThenOne() {
      Calculator calc = new Calculator();
      calc.substract(2D, 1D);
      double result = calc.getResult();
      double expected = 1D;
      assertThat(result, is(expected));
  }
    /**
     * test div.
     */
  @Test
    public void whenDivTwoOnTwoThenOne() {
      Calculator calc = new Calculator();
      calc.div(2D, 2D);
      double result = calc.getResult();
      double expected = 1D;
      assertThat(result, is(expected));
  }
    /**
     * test multiple.
     */
  @Test
    public void whenMultipleTwoByTwoThenFour() {
      Calculator calc = new Calculator();
      calc.multiple(2D, 2D);
      double result = calc.getResult();
      double expected = 4D;
      assertThat(result, is(expected));
  }
}


