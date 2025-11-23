package ru.Romanov.Main;

import ru.Romanov.Cache.CacheDemo;
import ru.Romanov.Cache.CacheProcessor;
import ru.Romanov.Default.DefaultDemo;
import ru.Romanov.Default.DefaultProcessor;
import ru.Romanov.Invoke.InvokeDemo;
import ru.Romanov.Invoke.InvokeProcessor;
import ru.Romanov.Tests.CacheTest;
import ru.Romanov.Tests.DefaultTest;
import ru.Romanov.ToString.ToStringDemo;
import ru.Romanov.ToString.ToStringProcessor;
import ru.Romanov.Two.TwoDemo;
import ru.Romanov.Two.TwoProcessor;
import ru.Romanov.Validate.ValidateDemo;
import ru.Romanov.Validate.ValidateProcessor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите номер задания 1-8: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        InvokeDemo demo = new InvokeDemo();
                        System.out.println("Автоматический вызов методов с" +
                                " аннотацией @ru.Romanov.Invoke.Invoke:");
                        InvokeProcessor.processInvokeAnnotations(demo);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        DefaultDemo demo = new DefaultDemo();
                        DefaultProcessor.processDefaultAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ToStringDemo demo = new ToStringDemo("TestObject", 123, 45.67);
                        String result = ToStringProcessor.toString(demo);
                        System.out.println("Строковое представление: " + result);
                        System.out.println("Поле excludedField" +
                                " с @ru.Romanov.ToString.ToString(Mode.NO) исключено из вывода");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        ValidateDemo demo = new ValidateDemo();
                        ValidateProcessor.processValidateAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        TwoDemo demo = new TwoDemo();
                        TwoProcessor.processTwoAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        CacheDemo demo = new CacheDemo();
                        CacheProcessor.processCacheAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        DefaultDemo demo = new DefaultDemo();
                        DefaultProcessor.processDefaultAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        CacheDemo demo = new CacheDemo();
                        CacheProcessor.processCacheAnnotations(demo.getClass());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Вводить можно только число 1-8!");
            }
        } else {
            System.out.println("Вводить можно только число 1-8!");
        }
    }
}