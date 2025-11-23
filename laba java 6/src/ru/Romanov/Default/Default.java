package ru.Romanov.Default;

import java.lang.annotation.*;

/**
 * Аннотация @Default - указание типа по умолчанию
 * Цель: TYPE, FIELD
 * Доступ: RUNTIME
 * Свойства: value (обязательный, Class)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    /**
     * Свойство value определяет тип по умолчанию
     *
     * @return класс типа по умолчанию
     */
    Class<?> value();
}
