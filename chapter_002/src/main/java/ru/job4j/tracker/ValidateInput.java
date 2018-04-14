package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
