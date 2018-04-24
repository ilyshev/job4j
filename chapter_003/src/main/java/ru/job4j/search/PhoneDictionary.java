package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Модель справочника.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * вернуть список всех пользователей, который содержит key в любых полях.
     * @param key Ключ поиска.
     * @return result.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (persons.iterator().next().getName().contains(key)
                    || persons.iterator().next().getSurname().contains(key)
                    || persons.iterator().next().getPhone().contains(key)
                    || persons.iterator().next().getAddress().contains(key)) {
                result.addAll(persons);
            }
        }
        return result;
    }
}
