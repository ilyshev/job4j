package ru.job4j.loop;

import java.util.function.BiPredicate;
/**
 * Построить пирамиду в псеводографике. Рефакторинг кода
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */

public class Paint {
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Рисуем правую сторону пирамиды.
     * @param height высота треугольника
     * @return результат
     */
    public String rightTrg(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
        /*//буфер для результата.
        StringBuilder screen = new StringBuilder();
        //ширина равна высоте.
        int width = height;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний определяет положение ячейки в строке.
            for (int column = 0; column != width; column++) {
                //если строка равна ячейки, то рисуем галку.
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            //перевод строки на новую.
            screen.append(System.lineSeparator());
        }
        //результат
        return screen.toString();
        */
    }
    /**
     * Рисуем левую сторону пирамиды.
     * @param height высота треугольника
     * @return результат
     */
    public String leftTrg(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
        /*//буфер для результата.
        StringBuilder screen = new StringBuilder();
        //ширина равна высоте.
        int width = height;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний определяет положение ячейки в строке.
            for (int column = 0; column != width; column++) {
                //если строка равна ячейки, то рисуем галку.
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            //перевод строки на новую.
            screen.append(System.lineSeparator());
        }
        //результат.
        return screen.toString();*/
    }

    /**
     * рисуем пирамиду.
     * @param height высота пирамиды.
     * @return результат.
     */
    public String piramid(int height) {
       return this.loopBy(
               height,
               2 * height - 1,
               (row, column) -> row >= height - column - 1 && row + height - 1 >= column
       );
        /* //буфер для резульатата.
        StringBuilder screen = new StringBuilder();
        //ширина в два раза больше высоты.
        int width = 2 * height - 1;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != width; column++) {
                //если строка равна ячейке, то рисуем галку.
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            //перевод строки на новую.
            screen.append(System.lineSeparator());
        }
        //результат.
        return screen.toString();*/
    }
}
