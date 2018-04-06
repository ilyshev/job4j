package ru.job4j.tracker;

import ru.job4j.tracker.*;

import java.util.*;
/**
 * класс Tracker
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Генератор уникального ключа.
     */
    private static final Random RN = new Random();
    /**
     * Метод добавления заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод замены заявки.
     *
     * @param id заменяемого элемента массива.
     * @param item новый элемент массива.
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < this.items.length; index++) {
            if (item.getId().equals(id)) {
                this.items[index] = item;
            }
        }
    }

    /**
     * Метод удаления заявок.
     *
     * @param id удаляемого элемента.
     */
    public void delete(String id) {
        int index = 0;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                break;
            } else {
                items[index] = item;
                index++;
            }
        }
    }

    /**
     * Метод получения списка всех заявок.
     *
     * @return список.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод получения списка по имени.
     *
     * @param key искомое имя
     * @return массив с найденными именами.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int index = 0;
        for (int j = 0; j != result.length; j++) {
            if (this.items[j].getName().equals(key)) {
                result[index] = this.items[j];
                index++;
            }
        }
        return result;
    }

    /**
     * Метод получения заявки по id.
     * @param id
     * @return result позиция из списка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}