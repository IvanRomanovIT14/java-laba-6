package ru.Romanov.Two;

/**
 * Демонстрационный класс для аннотации @Two
 * Показывает использование аннотации с двумя обязательными свойствами
 */
@Two(first = "Пример строки", second = 42)
public class TwoDemo {
    private String message;
    private int value;

    /**
     * Конструктор по умолчанию
     */
    public TwoDemo() {
        this.message = "TwoDemo Object";
        this.value = 100;
    }

    /**
     * Получить сообщение
     *
     * @return строковое сообщение
     */
    public String getMessage() {
        return message;
    }

    /**
     * Получить значение
     *
     * @return целое число
     */
    public int getValue() {
        return value;
    }

    /**
     * Установить сообщение
     *
     * @param message новое сообщение
     * @throws IllegalArgumentException если сообщение пустое
     */
    public void setMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым");
        }
        this.message = message;
    }
}
