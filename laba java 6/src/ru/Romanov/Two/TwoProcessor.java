package ru.Romanov.Two;

import java.lang.reflect.*;

/**
 * Обработчик аннотации @Two для работы с двумя свойствами
 * Выводит значения свойств first и second аннотации @Two
 */
public class TwoProcessor {

    /**
     * Обрабатывает класс и выводит значения свойств аннотации @Two
     *
     * @param clazz класс для обработки
     * @throws IllegalArgumentException если класс равен null или свойства некорректны
     */
    public static void processTwoAnnotations(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }

        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            System.out.println("Аннотация @Two:");
            System.out.println("  first: " + annotation.first());
            System.out.println("  second: " + annotation.second());

            // Проверка корректности значений
            if (annotation.first().isEmpty()) {
                throw new IllegalArgumentException("Свойство" +
                        " 'first' не может быть пустой строкой");
            }
            if (annotation.second() < 0) {
                throw new IllegalArgumentException("Свойство" +
                        " 'second' не может быть отрицательным");
            }
        }
    }
}