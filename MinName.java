package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import java.util.Comparator;
import java.util.Optional;

import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс MinName реализует команду вывода объекта из коллекции с минимальным значением поля name.
 */
public class MinName implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести любой объект из коллекции, значение поля name которого является минимальным";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "min_name";
    }

    /**
     * Выполняет команду вывода объекта с минимальным значением поля name.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        // Поиск продукта с минимальным значением поля name
        Optional<Product> minProduct = stringCollection.values().stream()
                .min(Comparator.comparing(Product::getName));

        // Если продукт найден, выводим его
        if (minProduct.isPresent()) {
            System.out.println(minProduct.get());
        } else {
            System.out.println("Коллекция пуста.");
        }
    }
}