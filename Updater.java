package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import java.util.Scanner;

import static CollectionObjects.Collectionss.stringCollection;
import static java.lang.Integer.parseInt;

/**
 * Класс Updater реализует команду обновления значения элемента коллекции по его ID.
 */
public class Updater implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "update_id";
    }

    /**
     * Выполняет команду обновления значения элемента коллекции по его ID.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        Scanner scanner = new Scanner(System.in);

        // Ввод ID элемента для обновления
        System.out.println("Введите ID");
        Integer id;
        try {
            id = parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат ID. Введите целое число.");
            return;
        }

        // Проверка наличия элемента с таким ID в коллекции
        if (!stringCollection.containsKey(id)) {
            System.err.println("Ошибка: Элемент с ID " + id + " не найден.");
            return;
        }

        // Ввод нового имени для элемента
        System.out.println("Введите новое имя");
        String newName = scanner.nextLine().trim();
        if (newName.isEmpty()) {
            System.err.println("Ошибка: Имя не может быть пустым.");
            return;
        }

        // Обновление элемента в коллекции
        Product productToUpdate = stringCollection.get(id);
        productToUpdate.SetName(newName);
        stringCollection.put(id, productToUpdate);

        System.out.println("Элемент с ID " + id + " успешно обновлен.");
    }
}