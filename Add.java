package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import static CollectionObjects.Collectionss.stringCollection;
import java.util.Random;
import java.util.Scanner;
import static Client.Filler.*;

/**
 * Класс Add реализует команду добавления нового элемента в коллекцию.
 */
public class Add implements Command {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " добавить новый элемент с заданным ключом";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * Выполняет команду добавления нового элемента в коллекцию.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        try {
            // Создание нового продукта с помощью метода createProduct
            Product cl1 = createProduct(scanner);
            Random random = new Random();
            Integer id;

            // Генерация уникального id
            do {
                id = random.nextInt(10000) + 1;
            } while (stringCollection.containsKey(id)); // Проверка на уникальность

            // Добавление элемента в коллекцию
            stringCollection.put(id, cl1);
            System.out.println("Продукт с ID " + id + " успешно добавлен.");
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
    }
}