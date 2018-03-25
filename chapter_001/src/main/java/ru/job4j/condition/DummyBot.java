package ru.job4j.condition;

/**
 * Глупый бот. Принимает фразу и возвращает ответ.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question вопрос.
     * @return rsl ответ.
     */
    public String answer (String question) {
        String rsl = "Это ставит меня в тупик. Задай другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, Умник.";
        } else if ("Пока".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
