package ru.job4j.tracker;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        Item previous = new Item();
        previous.setId(input.ask("Введите id редактируемой заявки: "));
        previous.setName(input.ask("Введите имя заявки: "));
        previous.setDescription(input.ask("Введите описание: "));
        tracker.replace(previous);
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int fillActions() {
        int count = 0;
        this.actions.add(count, new AddItem(count++, "Добавить новую заявку"));
        this.actions.add(count, new ShowItems(count++, "Список всех заявок"));
        this.actions.add(count, new EditItem(count++, "Редактировать заявку"));
        this.actions.add(count, new DelItem(count++, "Удалить заявку"));
        this.actions.add(count, new FindById(count++, "Найти заявку по id"));
        this.actions.add(count, new FindByName(count++, "Найти заявку по имени"));
        return count;
    }

 //   public void addAction(UserAction action) {
 //       this.actions[position++] = action;
 //   }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Использование метода добавления заявки.
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание: ");
            long date = System.currentTimeMillis();
            Item item = new Item(name, desc, date);
            tracker.add(item);
        }
    }

    /**
     * Использование метода показа всех заявок.
     */
    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
       @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                System.out.println(
                        String.format("%s %s %s", item.getId(), item.getName(), item.getDescription())
                );
                }
            }
        }
    }

    /**
     * Использование метода удаления заявки.
     */
    private class DelItem extends BaseAction {
        public DelItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id удаляемой заявки: ");
            tracker.delete(id);
        }
    }

    /**
     * Использование метода поиска по id.
     */
    public class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id: ");
            System.out.println(
                    String.format("%s %s %s",
                            tracker.findById(id).getId(),
                            tracker.findById(id).getName(),
                            tracker.findById(id).getDescription())
            );
        }
    }

    /**
     * Использование метода поиска по имени.
     */
    class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s %s %s",
                                item.getId(),
                                item.getName(),
                                item.getDescription())
                );
            }
        }
    }
}