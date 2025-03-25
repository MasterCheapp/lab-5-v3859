package Client;

import Controller.CommandsProvider;
import Controller.ConsoleCaller;
/**
 * Класс Main является точкой входа в программу.
 * Он инициализирует необходимые компоненты и запускает выполнение команд.
 */
public class Main {

    /**
     * Имя файла, переданное в качестве аргумента командной строки.
     */
    public static String filename;

    /**
     * Основной метод программы, который запускает выполнение.
     *
     * @param args аргументы командной строки. Первый аргумент должен содержать имя файла.
     */
    public static void main(String[] args) {
        // Проверка наличия аргумента командной строки
        if (args.length == 0) {
            System.out.println("Ошибка: Не указано имя файла в аргументах командной строки.");
            return;
        }
        // Сохранение имени файла из аргументов командной строки
        filename = args[0];

        // Создание объекта CommandsProvider для управления командами
        CommandsProvider commandsProvider = new CommandsProvider();

        // Создание объекта ConsoleCaller для вызова команд
        ConsoleCaller consoleCaller = new ConsoleCaller(commandsProvider);

        // Запуск выполнения команд
        consoleCaller.Call();
    }
}