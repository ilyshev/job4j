package ru.job4j.loop;

/**
 * Построить пирамиду в псеводографике.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Paint {
    /**
     * Рисуем правую сторону пирамиды.
     * @param height высота треугольника
     * @return результат
     */
    public String rightTrg(int height) {
        //буфер для результата.
        StringBuilder screen = new StringBuilder();
        //ширина равна высоте.
        int weight = height;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
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
    }
    /**
     * Рисуем левую сторону пирамиды.
     * @param height высота треугольника
     * @return результат
     */
    public String leftTrg(int height) {
        //буфер для результата.
        StringBuilder screen = new StringBuilder();
        //ширина равна высоте.
        int weight = height;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                //если строка равна ячейки, то рисуем галку.
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            //перевод строки на новую.
            screen.append(System.lineSeparator());
        }
        //результат.
        return screen.toString();
    }

    /**
     * рисуем пирамиду.
     * @param height высота пирамиды.
     * @return результат.
     */
    public String piramid(int height) {
        //буфер для резульатата.
        StringBuilder screen = new StringBuilder();
        //ширина в два раза больше высоты.
        int weight = 2 * height - 1;
        //внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            //внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
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
        return screen.toString();
    }
}
