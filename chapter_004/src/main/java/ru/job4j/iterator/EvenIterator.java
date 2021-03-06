package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * класс итератор для четных чисел
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version 0.1
 * @since 21/05/2018
 */

public class EvenIterator implements Iterator {
    private int[] numbers;
    private int index = 0;

    /**
     * конструктор класса.
     * @param numbers массив чисел.
     */
    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * метод проверки на четность числа.
     * @param i проверяемое число
     * @return истина / ложь
     */
    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < numbers.length; i++) {
            if (isEven(numbers[i])) {
                index = i;
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