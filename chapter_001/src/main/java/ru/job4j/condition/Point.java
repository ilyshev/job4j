package ru.job4j.condition;

/**
 * Расстояние между двумя точками.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Point {
    private int x;
    private int y;
    /**
     * конструктор типа данных Point.
     * @param x - x.
     * @param y - y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Вычисляем расстояние между двумя точками в системе координат.
     * @param that - координаты входящей точки
     * @return result - расстояние между двумя точками.
     */
    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        double result = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
        return result;
    }
    /**
     * вывод результата на консоль.
     * @param args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками A и B : " + result);
    }

}
