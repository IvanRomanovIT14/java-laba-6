package ru.Romanov.Validate;

/**
 * Демонстрационный класс для аннотации @Validate
 * Показывает использование аннотации с массивом классов для проверки
 */
@Validate({String.class, Integer.class, Double.class, Boolean.class})
public class ValidateDemo {
    private String data;
    private int number;
    private double value;
    private boolean flag;

    /**
     * Конструктор по умолчанию
     */
    public ValidateDemo() {
        this.data = "Validation Test Data";
        this.number = 42;
        this.value = 3.14;
        this.flag = true;
    }

    /**
     * Получить данные
     *
     * @return строковые данные
     */
    public String getData() {
        return data;
    }

    /**
     * Получить числовое значение
     *
     * @return целое число
     */
    public int getNumber() {
        return number;
    }

    /**
     * Получить значение с плавающей точкой
     *
     * @return число double
     */
    public double getValue() {
        return value;
    }

    /**
     * Получить флаг
     *
     * @return булево значение
     */
    public boolean isFlag() {
        return flag;
    }
}