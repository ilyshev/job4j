package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс итератор для простых чисел.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version 0.1
 * @since 25.05.2018
 */
public class PrimeIterator implements Iterator {
    private int[] numbers;
    private int index = 0;

    /**
     * конструктор класса.
     * @param numbers массив чисел.
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * метод проверки простого числа.
     * @param n проверяемое число.
     * @return истина / ложь.
     */
    public boolean isPrime(int n) {
        boolean result = true;
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    result =  false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                index = i;
                return true;
            }
        } return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No such element.");
        }
        return numbers[index++];
    }
}
