package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DummyBot test.
 *
 * @author Dmitry Ilyshev (dilyshev@mac.com).
 * @version $Id$.
 * @since 0.1.
 */
public class DummyBotTest {
    /**
     * Ответ на приветствие.
     */
    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот."),
                is("Привет, Умник.")
        );
    }

    /**
     * Ответ на прощание
     */
    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока"),
                is("До скорой встречи.")
        );
    }
    /**
     * Ответ в любом другом случае
     */
    @Test
    public void whenOtherBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Что нового?"),
                is("Это ставит меня в тупик. Задай другой вопрос.")
        );
    }
}