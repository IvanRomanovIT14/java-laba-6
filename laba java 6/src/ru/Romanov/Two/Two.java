package ru.Romanov.Two;

import java.lang.annotation.*;

/**
 * Аннотация @Two - два обязательных свойства
 * Цель: TYPE
 * Доступ: RUNTIME
 * Свойства: first (обязательный, String), second (обязательный, int)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    /**
     * Свойство first - строковое значение
     *
     * @return строковое значение
     */
    String first();

    /**
     * Свойство second - числовое значение
     *
     * @return целое число
     */
    int second();
}
