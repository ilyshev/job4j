package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс итератор для четных чисел массива.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version 0.1
 * @since 23/05/2018
 */
public class EvenIterator implements Iterator {
    private final int[] numbers;
    int index = 0;

    /**
     * конструктор класса.
     * @param numbers массив чисел.
     */
    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * метод проверки числа на четность.
     * @param i число.
     * @return чет - истина / ложь
     */
    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        for (int j = index; j < this.numbers.length; j++) {
            if (isEven(numbers[j])) {
                index = j;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No such element.");
        }
        return numbers[index++];
    }
}
