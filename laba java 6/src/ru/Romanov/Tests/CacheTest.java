package ru.Romanov.Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.Romanov.Cache.Cache;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для аннотации @Cache с использованием JUnit 5
 * Проверяет корректность работы механизма кеширования
 */
public class CacheTest {

    /**
     * Тестовый класс с несколькими областями кеширования
     */
    @Cache({"users", "orders", "products", "settings"})
    static class TestClassWithMultipleCacheAreas {
    }

    /**
     * Тестовый класс с пустым массивом областей кеширования
     */
    @Cache({})
    static class TestClassWithEmptyCache {
    }

    /**
     * Тестовый класс с одной областью кеширования
     */
    @Cache({"singleArea"})
    static class TestClassWithSingleCacheArea {
    }

    private Map<String, Object> mockCache;

    /**
     * Подготовка тестового окружения перед каждым тестом
     */
    @BeforeEach
    void setUp() {
        mockCache = new HashMap<>();
    }

    /**
     * Тест проверяет, что список кешируемых сущностей корректно считывается
     */
    @Test
    void testCacheAnnotationValuesAreCorrectlyRead() {
        Cache annotation = TestClassWithMultipleCacheAreas.class.getAnnotation(Cache.class);
        assertNotNull(annotation, "Аннотация @Cache должна присутствовать");

        String[] expectedAreas = {"users", "orders", "products", "settings"};
        assertArrayEquals(expectedAreas, annotation.value(),
                "Список кешируемых областей должен точно соответствовать ожидаемому");
    }

    /**
     * Мок-тест имитирует обращение к кешу с использованием встроенных подстановок
     */
    @Test
    void testMockCacheAccessSimulation() {
        Cache annotation = TestClassWithMultipleCacheAreas.class.getAnnotation(Cache.class);

        // Имитация обращения к кешу - добавление данных
        for (String cacheArea : annotation.value()) {
            mockCache.put(cacheArea, "cached_data_for_" + cacheArea);
        }

        // Проверка, что данные добавлены в кеш
        assertEquals(4, mockCache.size(), "В кеше должно быть 4 области");
        assertTrue(mockCache.containsKey("users"), "Кеш должен содержать область 'users'");
        assertTrue(mockCache.containsKey("orders"), "Кеш должен содержать область 'orders'");
        assertTrue(mockCache.containsKey("products"), "Кеш должен содержать область 'products'");
        assertTrue(mockCache.containsKey("settings"), "Кеш должен содержать область 'settings'");

        // Проверка значений в кеше
        assertEquals("cached_data_for_users", mockCache.get("users"));
        assertEquals("cached_data_for_orders", mockCache.get("orders"));
    }

    /**
     * Тест проверяет, что если массив пуст – кеширование не производится
     */
    @Test
    void testNoCachingWithEmptyArray() {
        Cache annotation = TestClassWithEmptyCache.class.getAnnotation(Cache.class);
        assertNotNull(annotation, "Аннотация @Cache должна присутствовать" +
                " даже при пустом массиве");
        assertEquals(0, annotation.value().length, "Массив " +
                "кешируемых областей должен быть пустым");

        // Попытка кеширования при пустом массиве
        for (String cacheArea : annotation.value()) {
            mockCache.put(cacheArea, "should_not_be_cached");
        }

        assertEquals(0, mockCache.size(),
                "При пустом массиве кешируемых областей кеш должен оставаться пустым");
    }

    /**
     * Отдельный тест для случая, когда кеш содержит несколько именованных областей
     */
    @Test
    void testMultipleNamedCacheAreas() {
        Cache annotation = TestClassWithMultipleCacheAreas.class.getAnnotation(Cache.class);
        String[] cacheAreas = annotation.value();

        assertEquals(4, cacheAreas.length, "Должно быть 4 именованные области кеширования");

        // Проверка всех областей по отдельности
        List<String> areasList = Arrays.asList(cacheAreas);
        assertTrue(areasList.contains("users"), "Должна присутствовать область 'users'");
        assertTrue(areasList.contains("orders"), "Должна присутствовать область 'orders'");
        assertTrue(areasList.contains("products"), "Должна присутствовать область 'products'");
        assertTrue(areasList.contains("settings"), "Должна присутствовать область 'settings'");

        // Проверка, что нет лишних областей
        assertEquals(4, areasList.size(), "Не должно быть лишних областей кеширования");
    }

    /**
     * Дополнительный тест для одной области кеширования
     */
    @Test
    void testSingleCacheArea() {
        Cache annotation = TestClassWithSingleCacheArea.class.getAnnotation(Cache.class);
        String[] cacheAreas = annotation.value();

        assertEquals(1, cacheAreas.length, "Должна быть одна область кеширования");
        assertEquals("singleArea", cacheAreas[0], "Область кеширования должна быть 'singleArea'");
    }
}