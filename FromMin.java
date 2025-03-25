package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс FromMin реализует команду вывода элементов коллекции в порядке возрастания цены.
 */
public class FromMin implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести элементы коллекции в порядке возрастания цены";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "from_min_to_max";
    }

    /**
     * Выполняет команду вывода элементов коллекции в порядке возрастания цены.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        // Проверка на null и пустую коллекцию
        if (stringCollection == null || stringCollection.isEmpty()) {
            System.out.println("Error: Коллекция пуста");
            return;
        }

        // Создаем список из элементов коллекции
        List<Map.Entry<Integer, Product>> list = new ArrayList<>(stringCollection.entrySet());

        // Сортируем по возрастанию цены
        list.sort(Comparator.comparingDouble(entry -> entry.getValue().getPrice()));

        // Выводим отсортированные элементы
        for (Map.Entry<Integer, Product> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}