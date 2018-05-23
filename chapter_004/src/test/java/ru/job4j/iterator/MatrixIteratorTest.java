package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * test итератора для двухмерного массива int[][]
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version 0.1
 * @since 21/05/2018
 */
public class MatrixIteratorTest {

    private Iterator<Integer> itJagged;
    private Iterator<Integer> itMatrix;

    @Before
    public void setUpJagged() {
        itJagged = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(7));
        assertThat(itJagged.hasNext(), is(false));
    }


    @Before
    public void setUpMatrix() {
        itMatrix = new MatrixIterator(
                new int[][] {{1, 2, 3}, {4, 5, 6}}
        );
    }

    @Test
    public void whenMatrixHasNextNextSequentialInvocation() {
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(1));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(2));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(3));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(4));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(5));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(6));
        assertThat(itMatrix.hasNext(), is(false));
    }

    @Test
    public void whenMatrixThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(itMatrix.next(), is(1));
        assertThat(itMatrix.next(), is(2));
        assertThat(itMatrix.next(), is(3));
        assertThat(itMatrix.next(), is(4));
        assertThat(itMatrix.next(), is(5));
        assertThat(itMatrix.next(), is(6));
    }

    @Test
    public void whenMatrixSequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.hasNext(), is(true));
        assertThat(itMatrix.next(), is(1));
        assertThat(itMatrix.next(), is(2));
        assertThat(itMatrix.next(), is(3));
        assertThat(itMatrix.next(), is(4));
        assertThat(itMatrix.next(), is(5));
        assertThat(itMatrix.next(), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        itMatrix = new MatrixIterator(new int[][]{});
        itMatrix.next();
    }
}