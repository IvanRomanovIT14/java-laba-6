package ru.Romanov.Invoke;

/**
 * Демонстрационный класс для аннотации @Invoke
 * Содержит методы с аннотацией @Invoke для автоматического вызова
 */
public class InvokeDemo {
    private int method1Count = 0;
    private int method2Count = 0;
    private int method3Count = 0;

    /**
     * Метод с аннотацией @Invoke - будет вызван автоматически
     */
    @Invoke
    public void method1() {
        method1Count++;
        System.out.println("  Метод method1() вызван (вызов №" + method1Count + ")");
    }

    /**
     * Обычный метод без аннотации - не будет вызван автоматически
     */
    public void method2() {
        method2Count++;
        System.out.println("  Метод method2() вызван вручную");
    }

    /**
     * Метод с аннотацией @Invoke - будет вызван автоматически
     */
    @Invoke
    public void method3() {
        method3Count++;
        System.out.println("  Метод method3() вызван (вызов №" + method3Count + ")");
    }

    /**
     * Метод с аннотацией @Invoke - будет вызван автоматически
     */
    @Invoke
    public void method4() {
        System.out.println("  Метод method4() с аннотацией @Invoke");
    }

    /**
     * Проверяет, был ли вызван method1
     *
     * @return true если method1 был вызван, иначе false
     */
    public boolean isMethod1Called() {
        return method1Count > 0;
    }

    /**
     * Проверяет, был ли вызван method2
     *
     * @return true если method2 был вызван, иначе false
     */
    public boolean isMethod2Called() {
        return method2Count > 0;
    }

    /**
     * Проверяет, был ли вызван method3
     *
     * @return true если method3 был вызван, иначе false
     */
    public boolean isMethod3Called() {
        return method3Count > 0;
    }

    /**
     * Строковое представление объекта с счетчиками вызовов
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "InvokeDemo{method1=" + method1Count + ", method2=" +
                method2Count + ", method3=" + method3Count + "}";
    }
}