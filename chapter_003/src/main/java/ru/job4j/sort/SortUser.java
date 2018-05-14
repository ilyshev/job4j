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
}
