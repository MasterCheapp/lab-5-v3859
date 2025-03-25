package Controller;

import CollectionObjects.Collectionss;

import java.util.Scanner;

/**
 * Класс App представляет основное приложение, которое управляет коллекцией и взаимодействует с пользователем.
 * Реализован как Singleton, чтобы гарантировать единственный экземпляр приложения.
 */
public class App {
    private Collectionss collectionss; // Объект коллекции
    private ConsoleCaller consoleCaller; // Объект для вызова команд
    private CommandsProvider commandsProvider; // Провайдер команд
    private static App app; // Единственный экземпляр приложения
    Scanner scanner = new Scanner(System.in); // Сканер для ввода данных от пользователя

    /**
     * Приватный конструктор для реализации Singleton.
     */
    private App() {
    }

    /**
     * Возвращает единственный экземпляр приложения (реализация Singleton).
     *
     * @return единственный экземпляр класса App.
     */
    public static App getApp() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    /**
     * Устанавливает объект коллекции.
     *
     * @param collectionss объект коллекции.
     */
    public void setCollectionss(Collectionss collectionss) {
        this.collectionss = collectionss;
    }

    /**
     * Возвращает провайдер команд.
     *
     * @return объект класса CommandsProvider.
     */
    public CommandsProvider getCommandProvider() {
        return commandsProvider;
    }
}