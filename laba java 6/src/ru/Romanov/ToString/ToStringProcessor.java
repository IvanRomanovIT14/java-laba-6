package ru.Romanov.ToString;

import java.lang.reflect.*;

/**
 * Обработчик аннотации @ToString для формирования строкового представления объектов
 */
public class ToStringProcessor {

    /**
     * Формирует строковое представление объекта с учетом аннотации @ToString
     *
     * @param obj объект для преобразования в строку
     * @return строковое представление объекта, включая только поля с @ToString(Mode.YES)
     * @throws IllegalArgumentException если объект равен null
     */
    public static String toString(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }

        Class<?> clazz = obj.getClass();
        StringBuilder result = new StringBuilder(clazz.getSimpleName() + "{");

        boolean firstField = true;
        for (Field field : clazz.getDeclaredFields()) {
            if (shouldIncludeField(field, clazz)) {
                try {
                    field.setAccessible(true);
                    if (!firstField) result.append(", ");
                    result.append(field.getName()).append("=").append(field.get(obj));
                    firstField = false;
                } catch (Exception e) {
                    // Игнорируем поля с ошибками доступа
                }
            }
        }

        return result.append("}").toString();
    }

    /**
     * Определяет, должно ли поле быть включено в строковое представление
     *
     * @param field поле для проверки
     * @param clazz класс, содержащий поле
     * @return true если поле должно быть включено, false если исключено
     */
    private static boolean shouldIncludeField(Field field, Class<?> clazz) {
        // Проверяем аннотацию на поле
        ToString fieldAnnotation = field.getAnnotation(ToString.class);
        if (fieldAnnotation != null) {
            return fieldAnnotation.value() == ToString.Mode.YES;
        }

        // Проверяем аннотацию на классе
        ToString classAnnotation = clazz.getAnnotation(ToString.class);
        if (classAnnotation != null) {
            return classAnnotation.value() == ToString.Mode.YES;
        }

        return true; // По умолчанию включаем поле
    }
}