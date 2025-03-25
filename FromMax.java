package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import java.util.*;
import static CollectionObjects.Collectionss.stringCollection;

/**
 * Класс FromMax реализует команду вывода элементов коллекции в порядке убывания цены.
 */
public class FromMax implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести элементы коллекции в порядке убывания цены";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "from_max_to_min";
    }

    /**
     * Выполняет команду вывода элементов коллекции в порядке убывания цены.
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

        // Сортируем по убыванию цены
        list.sort((entry1, entry2) -> {
            Double price1 = entry1.getValue().getPrice();
            Double price2 = entry2.getValue().getPrice();
            // Обработка null (если цена может быть null)
            if (price1 == null && price2 == null) return 0;
            if (price1 == null) return 1; // null считается больше, чтобы уйти в конец списка
            if (price2 == null) return -1;
            return Double.compare(price2, price1); // Сортировка по убыванию
        });

        // Выводим отсортированные элементы
        for (Map.Entry<Integer, Product> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}