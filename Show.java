package Controller.Commands;

import Controller.Command;

import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс Show реализует команду вывода всех элементов коллекции в строковом представлении.
 */
public class Show implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Выполняет команду вывода всех элементов коллекции в строковом представлении.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        // Проверка на пустую коллекцию
        if (stringCollection == null || stringCollection.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        // Вывод всех элементов коллекции
        System.out.println(stringCollection);
    }
}