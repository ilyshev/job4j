package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test Tracker
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class TrackerTest {
    /**
     * тест метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        List<Item> expect = new ArrayList<>();
        expect.add(item);
        assertThat(tracker.findAll(), is(expect));
    }

    /**
     * тест метода замены заявки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * тест метода удаления элемента по id.
     */
    @Test
    public void whenDeleteIdThenReturnNewArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item todelete = new Item("test2", "testDescription2", 1234L);
        tracker.add(todelete);
        tracker.delete(todelete.getId());
        List<Item> expect = Arrays.asList(item);
        assertThat(tracker.findAll(), is(expect));
    }

    /**
     * тест метода поиска всех элементов.
     */
    @Test
    public void whenSearchAllThenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);
        List<Item> expect = Arrays.asList(item, item2);
        assertThat(tracker.findAll(), is(expect));
    }

    /**
     * тест метода поиска по имени
     */
    @Test
    public void whenSearchByNameThenShowNewArrayWitKey() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("test1", "testDescription3", 12345L);
        tracker.add(item3);
        List<Item> expect = Arrays.asList(item, item3);
        assertThat(tracker.findByName(item.getName()), is(expect));
    }

    /**
     * тест метода поиска по id.
     */
    @Test
    public void whenSearchByIdThenShowItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
}