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
    private final List<Item> items = new ArrayList<>();

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
        items.add(item);
        return item;
    }

    /**
     * Метод замены заявки.
     *
     * @param item новый элемент массива.
     */
    public void replace(Item item) {
        for (Item index : items) {
            if (item.getId().equals(index.getId()) && item.getId() != null) {
                items.add(items.indexOf(index), item);
                break;
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
            if (item.getId().equals(id) && item != null) {
                items.remove(items.indexOf(item));
                break;
            }
        }
    }

    /**
     * Метод получения списка всех заявок.
     *
     * @return список.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод получения списка заявок по имени.
     *
     * @param key искомое имя
     * @return массив с найденными именами.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item :items) {
            if (item.getName().equals(key) && item != null) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод получения заявки по id.
     * @param id записи
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