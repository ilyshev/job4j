package ru.job4j.search;

/**
 * Класс Очередь с приоритетами.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определяет по полю приоритет.
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(task);
        if (task.getPriority() < tasks.getFirst().getPriority()) {
            tasks.add(0, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
