package ru.job4j.array;

/**
 *Перевернуть массив.
 *
 *@author Dmitry Ilyshev (dilyshev@mac.com).
 *@version $Id$.
 *@since 0.1.
 */
public class Turn {
    public int[] turn(int[] array) {
        //задаем цикл для половины массива, которая будет перевернута
        for (int index = 0; index < array.length / 2; index++) {
            //заменяемый элемент массива
            int swapElement = array[index];
            //заменяем значение выбранного элемента массива на соответствующий зеркальный с конца
            array[index] = array[array.length - 1 - index];
            //заменяем значение зеркального с конца элемента массива на порядковый с начала массива
            array[array.length - 1 - index] = swapElement;
        }
        return array;
    }
}
