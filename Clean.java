package Controller.Commands;

import Controller.Command;

import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс Clean реализует команду очистки коллекции.
 */
public class Clean implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " очистить коллекцию";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Выполняет команду очистки коллекции.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        stringCollection.clear();
        System.out.println("Коллекция успешно очищена.");
    }
}