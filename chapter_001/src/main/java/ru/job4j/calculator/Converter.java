package ru.job4j.calculator;

/**
 * Конвертер валют.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Converter {
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары.
     */
    public int rubToDollar(int value) {
        return value / 60;
    }
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public int rubToEuro(int value) {
        return value / 70;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRub(int value) {
        return value * 60;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRub(int value) {
        return  value * 70;
    }
}
