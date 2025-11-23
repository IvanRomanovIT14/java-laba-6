package ru.Romanov.Cache;

import java.lang.annotation.*;

/**
 * Аннотация @Cache - указание кешируемых областей
 * Цель: TYPE
 * Доступ: RUNTIME
 * Свойства: value (необязательный, String[], по умолчанию пустой массив)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {
    /**
     * Свойство value определяет массив кешируемых областей
     *
     * @return массив строк с названиями областей кеширования
     */
    String[] value() default {};
}