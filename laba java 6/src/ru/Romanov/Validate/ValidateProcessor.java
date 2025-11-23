package ru.Romanov.Validate;

import java.lang.reflect.*;

/**
 * Обработчик аннотации @Validate для работы с классами валидации
 * Выводит список классов, указанных в аннотации @Validate
 */
public class ValidateProcessor {

    /**
     * Обрабатывает класс и выводит список классов для проверки
     *
     * @param clazz класс для обработки
     * @throws IllegalArgumentException если класс равен null или массив классов пуст
     */
    public static void processValidateAnnotations(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }

        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            Class<?>[] classes = annotation.value();

            if (classes.length == 0) {
                throw new IllegalArgumentException("Массив классов в аннотации @Validate" +
                        " не может быть пустым");
            }

            System.out.println("Классы для проверки в " + clazz.getSimpleName() + ":");
            for (Class<?> cls : classes) {
                System.out.println("  - " + cls.getName());
            }
        }
    }
}
