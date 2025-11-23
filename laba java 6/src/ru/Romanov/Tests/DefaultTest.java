package ru.Romanov.Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.Romanov.Default.Default;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для аннотации @Default с использованием JUnit 5
 * Проверяет корректность обработки аннотации @Default
 */
public class DefaultTest {

    /**
     * Тестовый класс с типом по умолчанию String
     */
    @Default(String.class)
    static class TestClassWithStringDefault {
    }

    /**
     * Тестовый класс с типом по умолчанию Integer
     */
    @Default(Integer.class)
    static class TestClassWithIntegerDefault {
    }

    /**
     * Тестовый класс с типом по умолчанию Double и аннотацией на поле
     */
    @Default(Double.class)
    static class TestClassWithDoubleDefault {
        /**
         * Поле с типом по умолчанию Boolean
         */
        @Default(Boolean.class)
        private Object fieldWithBooleanDefault;
    }

    /**
     * Тест проверяет, что значение свойства value совпадает с ожидаемым классом
     */
    @Test
    void testDefaultAnnotationValueMatchesExpectedClass() {
        Default annotation = TestClassWithStringDefault.class.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна присутствовать на классе");
        assertEquals(String.class, annotation.value(), "Значение value должно быть String.class");
    }

    /**
     * Тест убеждается, что Reflection корректно возвращает экземпляр аннотации
     *
     * @throws NoSuchFieldException если поле не найдено
     */
    @Test
    void testReflectionReturnsAnnotationInstance() throws NoSuchFieldException {
        Field field = TestClassWithDoubleDefault.class.getDeclaredField("fieldWithBooleanDefault");
        Default fieldAnnotation = field.getAnnotation(Default.class);

        assertNotNull(fieldAnnotation, "Reflection должен возвращать аннотацию с поля");
        assertEquals(Boolean.class, fieldAnnotation.value(), "Аннотация" +
                " на поле должна иметь значение Boolean.class");

        Default classAnnotation = TestClassWithDoubleDefault.class.getAnnotation(Default.class);
        assertNotNull(classAnnotation, "Reflection должен возвращать аннотацию с класса");
        assertEquals(Double.class, classAnnotation.value(), "Аннотация на классе" +
                " должна иметь значение Double.class");
    }

    /**
     * Параметризованный тест для проверки нескольких классов с разными типами по умолчанию
     *
     * @param testClass           тестируемый класс
     * @param expectedDefaultType ожидаемый тип по умолчанию
     */
    @ParameterizedTest
    @MethodSource("defaultClassesProvider")
    void testParameterizedDefaultAnnotations(Class<?> testClass, Class<?> expectedDefaultType) {
        Default annotation = testClass.getAnnotation(Default.class);
        assertNotNull(annotation, "Аннотация @Default должна присутствовать на " +
                testClass.getSimpleName());
        assertEquals(expectedDefaultType, annotation.value(),
                "Тип по умолчанию для " + testClass.getSimpleName() + " должен быть " +
                        expectedDefaultType.getSimpleName());
    }

    /**
     * Поставщик данных для параметризованного теста
     *
     * @return поток аргументов для тестирования разных классов
     */
    private static Stream<Arguments> defaultClassesProvider() {
        return Stream.of(
                Arguments.of(TestClassWithStringDefault.class, String.class),
                Arguments.of(TestClassWithIntegerDefault.class, Integer.class),
                Arguments.of(TestClassWithDoubleDefault.class, Double.class)
        );
    }
}