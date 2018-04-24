package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "54321", "Bryansk")
        );
        List<Person> persons = phones.find("54321");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}