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
     * Константа меню для добавления новой заявки
     */
    private static final String ADD = "0";
    /**
     * Константа показа всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа показа всех заявок.
     */
    private static final String EDIT = "2";
    /**
     * Константа показа всех заявок.
     */
    private static final String DEL = "3";
    /**
     * Константа показа всех заявок.
     */
    private static final String FINDID = "4";
    /**
     * Константа показа всех заявок.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Выберите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.delItem();
            } else if (FINDID.equals(answer)) {
                this.findId();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод добавления новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание: ");
        long date = System.currentTimeMillis();
        Item item = new Item(name, desc, date);
        this.tracker.add(item);
        System.out.println("Создана новая заявка с id : " + item.getId());
    }
    /**
     * Метод вывода всех заявок на экран.
     */
    private void showAll() {
        System.out.println("------------ Список всех заявок --------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(this.tracker.findAll()[i].getId()
                    + " " + this.tracker.findAll()[i].getName()
                    + " " + this.tracker.findAll()[i].getDescription());
        }
        System.out.println("------------ Конец списка --------------");
    }
    /**
     * Метод редактирования заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id редактируемой заявки : ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите описание для новой заявки: ");
        long date = System.currentTimeMillis();
        Item item = new Item(name, desc, date);
        this.tracker.replace(id, item);
        System.out.println("Заявка с id: " + item.getId() + " отредактирована.");
    }
    /**
     * Метод удаления заявки.
     */
    private void delItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления: ");
        this.tracker.delete(id);
        System.out.println("Заявка с id: " + id + " удалена.");
    }
    /**
     * Метод поиска заявки по Id.
     */
    private void findId() {
        System.out.println("------------ Поиск заявки по id--------------");
        String id = this.input.ask("Введите id искомой заявки: ");
        System.out.println("Результат поиска: " + this.tracker.findById(id));
    }
    /**
     * Метод поиска заявки по имени.
     */
    private void findName() {
        System.out.println("------------ Поиск заявки по имени--------------");
        String key = this.input.ask("Введите имя искомой заявки: ");
        System.out.println("Результат поиска: " + Arrays.toString(this.tracker.findByName(key)));
    }
    /**
     * Метод показа пунктов меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.print("0. Добавить заявку\n"
                + "1. Показать все заявки\n"
                + "2. Редактировать заявку\n"
                + "3. Удалить заявку \n"
                + "4. Найти заявку по Id\n"
                + "5. Найти заявки по имени\n"
                + "6. Выход\n");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
