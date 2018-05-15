package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * тест класса сравнения пользователей по возрасту.
 * @author Dmitry ILyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    /**
     * если выводит список пользователей, то сортировка по возрасту
     */
    @Test
    public void whenShowAllUsersThenSortByAge() {
        SortUser user = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("John", 34));
        users.add(new User("Max", 27));
        users.add(new User("Freddy", 45));
        Set<User> expect = new TreeSet<>();
        expect.addAll(users);
        Set<User> result = user.sort(users);
        assertThat(result, is(expect));
    }
    /**
     * если вывод списка, то сортировка по длине имени от меньшего к большему.
     */
    @Test
    public void whenShowAllThenSortByNameLength() {
        SortUser user = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Sergey", 25));
        users.add(new User("Ivan", 30));
        users.add(new User("Bob", 20));
        users.add(new User("Johnattan", 25));
        List<User> result = user.sortNameLength(users);
        assertThat(result.iterator().next().getName(), is("Bob"));
    }
    /**
     * если вывод списка, то сортировка по длине имени и возрасту.
     */
    @Test
    public void whenShowAllThenSortByAllFields() {
        SortUser user = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Sergey", 25));
        users.add(new User("Ivan", 30));
        users.add(new User("Ivan", 45));
        users.add(new User("Johnattan", 25));
        List<User> result = user.sortByAllFields(users);
        assertThat(result.iterator().next().getAge(), is(30));
        assertThat(result.iterator().next().getName(), is("Ivan"));
    }
}