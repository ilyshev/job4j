package ru.job4j.tracker;

import ru.job4j.tracker.*;

class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id редактируемой заявки: ");
        String name = input.ask("Введите имя заявки: ");
        String desc = input.ask("Введите описание: ");
        Task task = new Task(name, desc);
        task.setId(id);
        long date = System.currentTimeMillis();
        tracker.replace(id, task);
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem(0, "Добавить новую заявку");
        this.actions[position++] = new ShowItems(1, "Список всех заявок");
        this.actions[position++] = new EditItem(2, "Редактировать заявку");
        this.actions[position++] = new DelItem(3, "Удалить заявку");
        this.actions[position++] = new FindById(4, "Найти заявку по id");
        this.actions[position++] = new FindByName(5, "Найти заявку по имени");
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
            for (int i = 0; i < tracker.findByName(name).length; i++) {
                System.out.println(
                        String.format("%s %s %s",
                                tracker.findByName(name)[i].getId(),
                                tracker.findByName(name)[i].getName(),
                                tracker.findByName(name)[i].getDescription())
                );
            }
        }
    }
}