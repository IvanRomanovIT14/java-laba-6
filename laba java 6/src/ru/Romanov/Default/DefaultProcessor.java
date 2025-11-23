package ru.Romanov.Default;

import java.lang.reflect.*;

/**
 * Обработчик аннотации @Default для работы с типами по умолчанию
 * Выводит информацию о типах по умолчанию для классов и полей
 */
public class DefaultProcessor {

    /**
     * Обрабатывает класс и выводит информацию о типах по умолчанию
     *
     * @param clazz класс для обработки
     * @throws IllegalArgumentException если класс равен null
     */
    public static void processDefaultAnnotations(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }

        // Обработка аннотации на классе
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("Класс " + clazz.getSimpleName() + " имеет тип по умолчанию: "
                    + annotation.value().getName());
        }

        // Обработка аннотаций на полях
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() + " имеет тип по умолчанию: "
                        + annotation.value().getName());
            }
        }
    }
}
