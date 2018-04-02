package ru.job4j.loop;

/**
 * Построить шахматную доску в псеводографике.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Board {
    /**
     * Метод paint, который рисует шахматную доску из символов x и пробелов.
     * @param width ширина доски.
     * @param height высота доски.
     * @return toString.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.getProperty("line.separator");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
