package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import ru.job4j.map.User;

/**
 * класс преобразования List в Map.
 * @author Dmitry ILyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    /**
     * метод преобразования list to map.
     * @param list список
     * @return result интерфейс map
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User users : list) {
            result.put(users.getId(), users);
        }
        return result;
    }
}
