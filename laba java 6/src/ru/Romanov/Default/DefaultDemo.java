package ru.Romanov.Default;

/**
 * Демонстрационный класс для аннотации @Default
 * Показывает использование аннотации на классе и полях
 */
@Default(String.class)
public class DefaultDemo {
    /**
     * Поле с типом по умолчанию Integer
     */
    @Default(Integer.class)
    private Object field1;

    /**
     * Поле с типом по умолчанию Double
     */
    @Default(Double.class)
    private Object field2;

    private String name;

    /**
     * Поле с типом по умолчанию Boolean
     */
    @Default(Boolean.class)
    private Object field3;

    /**
     * Конструктор по умолчанию
     */
    public DefaultDemo() {
        this.name = "DefaultDemo Object";
        this.field1 = 123;
        this.field2 = 45.67;
        this.field3 = true;
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
     * Получить значение field1
     *
     * @return значение field1
     */
    public Object getField1() {
        return field1;
    }

    /**
     * Получить значение field2
     *
     * @return значение field2
     */
    public Object getField2() {
        return field2;
    }

    /**
     * Получить значение field3
     *
     * @return значение field3
     */
    public Object getField3() {
        return field3;
    }
}