package ru.Romanov.ToString;

import java.lang.annotation.*;

/**
 * Аннотация @ToString - управление строковым представлением
 * Цель: TYPE, FIELD
 * Доступ: RUNTIME
 * Свойства: value (необязательный, Mode, по умолчанию YES)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    /**
     * Перечисление режимов отображения для аннотации @ToString
     */
    enum Mode {
        /**
         * Включить поле в строковое представление
         */
        YES,
        /**
         * Исключить поле из строкового представления
         */
        NO
    }

    /**
     * Свойство value определяет режим отображения поля
     *
     * @return режим отображения (YES или NO)
     */
    Mode value()
            default Mode.YES;
}