package Controller.Commands;

import Controller.Command;

import java.util.Date;

import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс Inform реализует команду вывода информации о коллекции.
 */
public class Inform implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Выполняет команду вывода информации о коллекции.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        // Получение типа коллекции
        String collectionType = stringCollection.getClass().getSimpleName();

        // Получение текущей даты и времени
        Date initializationDate = new Date();

        // Получение количества элементов в коллекции
        int elementCount = stringCollection.size();

        // Вывод информации о коллекции
        System.out.println("Информация о коллекции:");
        System.out.println("Тип коллекции: " + collectionType);
        System.out.println("Дата инициализации: " + initializationDate);
        System.out.println("Количество элементов: " + elementCount);
    }
}