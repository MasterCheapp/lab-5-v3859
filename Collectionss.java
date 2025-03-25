package CollectionObjects;

import java.util.HashMap;

/**
 * Класс Collectionss представляет коллекцию продуктов, хранящуюся в виде HashMap.
 * Ключом является целое число (ID продукта), а значением — объект класса Product.
 */
public class Collectionss {

    /**
     * Статическое поле, представляющее коллекцию продуктов.
     * Ключом является целое число (ID продукта), а значением — объект класса Product.
     */
    public static HashMap<Integer, Product> stringCollection = new HashMap<>();

    Integer g = 4;
    int f = g;
}