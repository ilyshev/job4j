package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * тест StartUI
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    /**
     * тест добавления новой заявки.
     */
    @Test
    public void whenAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /**
     * тест редактирования заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    /**
     * тест удаления заявки.
     */
    @Test
    public void whenDeleteItemThenTrackerDeletes() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Item item2 = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(item2.getId()));
    }

    private final Tracker tracker = new Tracker();
    private final Item item = tracker.add(new Item());

    @Before
    public void setInput() {
        System.out.println("Начало метода");
    }
    @After
    public void setOutput() {
        System.out.println("Конец метода");
    }
    /**
     * тест отображения списка заявок.
     */
    @Test
    public void whenShowAllThenTrackerShowsAllItems() {
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findAll()[0], is(item));
    }
    @Test
    public void whenShowByIdThenTrackerShowsItem() {
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById(item.getId()).getId(), is(item.getId()));
    }
}