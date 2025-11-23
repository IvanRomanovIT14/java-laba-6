package ru.Romanov.ToString;

/**
 * Демонстрационный класс для аннотации @ToString
 * Показывает работу аннотации на классе и отдельных полях
 */
@ToString
public class ToStringDemo {
    /**
     * Имя объекта - будет включено в строковое представление
     */
    private String name = "Test";

    /**
     * Числовое значение - будет включено в строковое представление
     */
    private int value = 100;

    /**
     * Поле, исключенное из строкового представления
     * Аннотация @ToString(Mode.NO) исключает это поле
     */
    @ToString(value = ToString.Mode.NO)
    private String excludedField = "Excluded";

    /**
     * Поле без аннотации - будет включено по умолчанию
     */
    private String includedField = "Included";

    /**
     * Конструктор демонстрационного класса
     *
     * @param name   имя объекта
     * @param value  числовое значение
     * @param unused неиспользуемый параметр
     */
    public ToStringDemo(String name, int value, double unused) {
        this.name = name;
        this.value = value;
    }

    /**
     * Получить имя объекта
     *
     * @return имя объекта
     */
    public String getName() {
        return name;
    }

    /**
     * Получить числовое значение
     *
     * @return числовое значение
     */
    public int getValue() {
        return value;
    }
}