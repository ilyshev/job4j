package ru.job4j.tracker;

import ru.job4j.tracker.*;

class EditItem implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id редактируемой заявки: ");
        String name = input.ask("Введите имя заявки: ");
        String desc = input.ask("Введите описание: ");
        Task task = new Task(name, desc);
        task.setId(id);
        long date = System.currentTimeMillis();
        //Item item = new Item(name, desc, date);
        tracker.replace(id, task);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Редактировать заявку");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DelItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
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

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание: ");
            long date = System.currentTimeMillis();
            Item item = new Item(name, desc, date);
            tracker.add(new Task(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку");
        }
    }
    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s %s %s", item.getId(), item.getName(), item.getDescription())
                );
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Список всех заявок");
        }
    }
    private static class DelItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id удаляемой заявки: ");
            tracker.delete(id);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }
    private static class FindById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id: ");
            System.out.println(
                    String.format("%s %s %s",
                            tracker.findById(id).getId(),
                            tracker.findById(id).getName(),
                            tracker.findById(id).getDescription())
            );
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по id");
        }
    }
    private static class FindByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            for (int i = 0; i < tracker.findByName(name).length; i++) {
                System.out.println(
                        String.format("%s %s %s",
                                tracker.findByName(name)[i].getId(),
                                tracker.findById(name).getName(),
                                tracker.findById(name).getDescription())
                );
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по имени");
        }
    }
}