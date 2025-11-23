package ru.Romanov.Invoke;

import java.lang.reflect.*;

/**
 * Обработчик аннотации @Invoke для автоматического вызова методов
 * Использует Reflection API для поиска и выполнения методов с аннотацией @Invoke
 */
public class InvokeProcessor {

    /**
     * Обрабатывает объект, находя и вызывая все методы с аннотацией @Invoke
     *
     * @param obj объект для обработки
     * @throws IllegalArgumentException если объект равен null
     */
    public static void processInvokeAnnotations(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                    System.out.println("Автоматически вызван метод: " + method.getName());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.err.println("Ошибка при вызове метода " + method.getName() +
                            ": " + e.getMessage());
                }
            }
        }
    }
}
