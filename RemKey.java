package Controller.Commands;

import Controller.Command;
import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс RemKey реализует команду удаления элемента из коллекции по его ключу.
 */
public class RemKey implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " удалить элемент из коллекции по его ключу";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "remove_key";
    }

    /**
     * Выполняет команду удаления элемента из коллекции по его ключу.
     *
     * @param arg аргумент команды, представляющий ключ элемента для удаления.
     */
    @Override
    public void execute(String arg) {
        try {
            // Преобразование аргумента в целое число (ключ)
            Integer key = Integer.parseInt(arg);

            // Удаление элемента по ключу
            if (stringCollection.containsKey(key)) {
                stringCollection.remove(key);
                System.out.println("Элемент с ключом " + key + " успешно удален.");
            } else {
                System.out.println("Элемент с ключом " + key + " не найден.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат ключа. Ключ должен быть целым числом.");
        }
    }
}