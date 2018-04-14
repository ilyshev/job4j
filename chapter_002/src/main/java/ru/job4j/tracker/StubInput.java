package ru.job4j.tracker;

/**
 * Класс
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например, если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] answers;
    /**
     * Поле считает количество вызово метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.answers[position++];
    }

    public int ask(String question, int[] range) {
       // throw new UnsupportedOperationException("Операция не поддерживается");
        return -1;
    }
}