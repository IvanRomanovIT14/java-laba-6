package ru.Romanov.Invoke;

import java.lang.annotation.*;

/**
 * Аннотация @Invoke - для автоматического вызова методов
 * Цель: METHOD
 * Доступ: RUNTIME
 * Свойства: нет свойств
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Invoke {
    // Аннотация не имеет свойств, только маркирует методы для автоматического вызова
}
