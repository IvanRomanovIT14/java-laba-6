package ru.Romanov.Cache;

import java.lang.reflect.*;
import java.util.*;

/**
 * Обработчик аннотации @Cache для работы с кешируемыми областями
 * Выводит список областей кеширования и создает мок-объекты кеша
 */
public class CacheProcessor {

    /**
     * Обрабатывает класс и выводит список кешируемых областей
     *
     * @param clazz класс для обработки
     * @throws IllegalArgumentException если класс равен null
     */
    public static void processCacheAnnotations(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }

        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            String[] cacheAreas = annotation.value();

            if (cacheAreas.length == 0) {
                System.out.println("Класс " + clazz.getSimpleName() + ": список кешируемых областей пуст");
            } else {
                System.out.println("Кешируемые области для " + clazz.getSimpleName() + ":");
                for (String area : cacheAreas) {
                    System.out.println("  - " + area);
                }
            }
        }
    }

    /**
     * Создает мок-объект кеша на основе аннотации @Cache
     *
     * @param clazz класс с аннотацией @Cache
     * @return Map с кешируемыми областями и тестовыми данными
     */
    public static Map<String, Object> createMockCache(Class<?> clazz) {
        Map<String, Object> mockCache = new HashMap<>();

        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            String[] cacheAreas = annotation.value();

            // Заполняем мок-кеш тестовыми данными
            for (String area : cacheAreas) {
                mockCache.put(area, "cached_data_for_" + area);
            }
        }

        return mockCache;
    }
}
