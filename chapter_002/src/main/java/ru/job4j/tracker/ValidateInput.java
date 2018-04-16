package ru.job4j.tracker;

/**
 * Валидатор
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Ошибка ввода. Введите корректный пункт меню.");
            } catch (MenuOutExeption moe) {
                System.out.println("Такого пункта не существует, введите корректный.");
            }
        } while (invalid);
         return value;
    }
}
