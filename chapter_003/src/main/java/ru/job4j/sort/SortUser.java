package ru.job4j.sort;

import java.util.*;


/**
 * класс сравнения пользователей по возрасту.
 * @author Dmitry ILyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * метод сортировки пользователей по имени.
     * @param users список пользователей.
     * @return users отсортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(final User left, final User right) {
                return left.getName().compareTo(right.getName());
            }
        });
        return users;
    }

    /**
     * метод сортировки по обоим полям: имени и возрасту.
     * @param users список пользователей.
     * @return users отсортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(final User left, final User right) {
                final int result = left.getName().compareTo(right.getName());
                return result != 0 ? result : Integer.compare(left.getAge(), right.getAge());
            }
        });
        return users;
    }
}
