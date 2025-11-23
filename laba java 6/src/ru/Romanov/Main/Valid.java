package ru.Romanov.Main;

import java.util.Scanner;

/**
 * Утилитарный класс для валидации пользовательского ввода
 * Предоставляет методы для безопасного получения данных от пользователя
 */
public class Valid {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Получает и валидирует целое число от пользователя
     *
     * @return валидное целое число
     */
    public static int getInt() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Получает и валидирует число с плавающей точкой от пользователя
     *
     * @return валидное число double
     */
    public static double getDouble() {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.print("Ошибка! Введите число: ");
                scanner.nextLine();
            }
        }
    }

    /**
     * Получает и валидирует непустую строку от пользователя
     *
     * @param fieldName название поля для сообщения об ошибке
     * @return валидная непустая строка
     */
    public static String getString(String fieldName) {
        while (true) {
            try {
                String value = scanner.nextLine().trim();
                if (value.isEmpty()) {
                    System.out.print("Ошибка! " + fieldName + " не может быть пустым: ");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.print("Ошибка ввода! Попробуйте снова: ");
            }
        }
    }
}
