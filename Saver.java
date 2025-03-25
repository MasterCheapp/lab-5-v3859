package Controller.Commands;

import Controller.Command;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static CollectionObjects.Collectionss.stringCollection;
import static Client.Main.filename;

/**
 * Класс Saver реализует команду сохранения коллекции в файл.
 */
public class Saver implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " сохранить коллекцию в файл";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "save";
    }

    /**
     * Выполняет команду сохранения коллекции в файл.
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        try (OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(filename))) {
            // Запись коллекции в файл
            outputStream.write(stringCollection.toString());
            System.out.println("Коллекция успешно сохранена в файл: " + filename);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
        }
    }
}

