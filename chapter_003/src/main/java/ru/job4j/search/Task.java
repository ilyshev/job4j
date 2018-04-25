package ru.job4j.search;

/**
 * Класс задача.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getDesc() {
        return desc;
    }
}
