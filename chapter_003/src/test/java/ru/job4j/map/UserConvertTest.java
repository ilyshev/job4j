package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * тест класса преобразования List в Map.
 * @author Dmitry ILyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {

    @Test
    public void whenGetUser2ThenCityLA() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();
        User john = new User(1, "John", "NY");
        User piter = new User(2, "Piter", "LA");
        users.add(john);
        users.add(piter);
        HashMap<Integer, User> result = convert.process(users);
        assertThat(result.get(2).getCity(), is("LA"));
    }
}