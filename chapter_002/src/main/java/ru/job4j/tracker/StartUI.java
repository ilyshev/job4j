package ru.job4j.tracker;

import ru.job4j.tracker.*;

import java.util.Arrays;

/**
 * Точка входа в программу
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор, инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = new int[]{0, 1, 2, 3, 4, 5};
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню: ", range));
        } while (!"y".equals(this.input.ask("Для выхода нажмите 'y': ")));
    }

    /**
     * вывод программы на экран.
     * @param args args
     */
    public static void main(String[] args) {
       // Input input = new ValidateInput();
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
