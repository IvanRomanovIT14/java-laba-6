package ru.Romanov.Validate;

import java.lang.annotation.*;

/**
 * Аннотация @Validate - указание типов для проверки
 * Цель: TYPE, ANNOTATION_TYPE
 * Доступ: RUNTIME
 * Свойства: value (обязательный, Class[])
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Validate {
    /**
     * Свойство value определяет массив классов для проверки
     *
     * @return массив классов для валидации
     */
    Class<?>[] value();
}