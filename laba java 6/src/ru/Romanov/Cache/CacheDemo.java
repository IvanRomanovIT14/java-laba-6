package ru.Romanov.Cache;

/**
 * Демонстрационный класс для аннотации @Cache
 * Показывает использование аннотации с несколькими областями кеширования
 */
@Cache({"users", "orders", "products", "settings", "cache"})
public class CacheDemo {
    private String data;
    private int cacheSize;
    private boolean enabled;

    /**
     * Вложенный класс с пустым кешем для демонстрации
     */
    @Cache()
    public static class EmptyCacheDemo {
        private String name;

        /**
         * Конструктор по умолчанию
         */
        public EmptyCacheDemo() {
            this.name = "EmptyCacheDemo";
        }

        /**
         * Получить имя
         *
         * @return имя объекта
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Конструктор по умолчанию
     */
    public CacheDemo() {
        this.data = "CacheDemo Object";
        this.cacheSize = 1024;
        this.enabled = true;
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
     * Получить размер кеша
     *
     * @return размер кеша
     */
    public int getCacheSize() {
        return cacheSize;
    }

    /**
     * Проверить, включен ли кеш
     *
     * @return true если кеш включен
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Установить данные
     *
     * @param data новые данные
     * @throws IllegalArgumentException если данные пустые
     */
    public void setData(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Данные не могут быть пустыми");
        }
        this.data = data;
    }

    /**
     * Вывести информацию о кеше
     */
    public void displayCacheInfo() {
        System.out.println("Кеш демо: " + data + ", размер: " + cacheSize);
    }
}
