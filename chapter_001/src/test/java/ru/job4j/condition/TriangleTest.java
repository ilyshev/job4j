package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
/**
 * Test Вычисление площади треугольника
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since    0.1.
 */

public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ождаемый результат.
        double expected = 2D;
        //Проверяем результат.
        assertThat(result, closeTo(expected, 0.1));
    }
}