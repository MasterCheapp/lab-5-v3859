package Controller.Commands;

import CollectionObjects.Product;
import Controller.Command;

import java.util.Scanner;

import static CollectionObjects.Collectionss.stringCollection;
import static java.lang.Integer.parseInt;

/**
 * Класс Replace_Lower реализует команду замены значения по ключу, если новое значение меньше старого.
 */
public class Replace_Lower implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " заменить значение по ключу, если новое значение меньше старого";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "replace_l";
    }

    /**
     * Выполняет команду замены значения по ключу, если новое значение меньше старого.
     *
     * @param arg аргумент команды, представляющий ключ элемента, который нужно заменить.
     */
    @Override
    public void execute(String arg) {
        Scanner scanner = new Scanner(System.in);

        // Преобразование аргумента в целое число (ключ элемента)
        Integer key = parseInt(arg);

        // Ввод нового значения цены
        System.out.println("Введите новое значение цены");
        double newValue;
        try {
            newValue = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат числа. Введите число с плавающей точкой.");
            return;
        }

        // Создание нового продукта с новой ценой
        Product newProduct = new Product();
        newProduct.setPrice(newValue);

        // Проверка на null коллекции
        if (stringCollection == null) {
            throw new IllegalArgumentException("Ошибка: Коллекция не инициализирована.");
        }

        // Получение старого значения по ключу
        Product oldValue = stringCollection.get(key);

        // Проверка, существует ли элемент с таким ключом
        if (oldValue == null) {
            System.out.println("Элемент с ключом '" + key + "' не найден.");
            return;
        }

        // Замена значения, если новое значение меньше старого
        if (newProduct.getPrice() < oldValue.getPrice()) {
            stringCollection.put(key, newProduct);
            System.out.println("Значение для ключа '" + key + "' заменено на: " + newValue);
        } else {
            System.out.println("Значение для ключа '" + key + "' не заменено, так как новое значение не меньше старого.");
        }
    }
}