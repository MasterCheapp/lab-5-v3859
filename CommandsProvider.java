package Controller;

import Controller.Commands.*;
import java.util.*;

/**
 * Класс `CommandsProvider` предоставляет доступ к набору команд, доступных в приложении.
 * Он инициализирует и хранит команды в `HashMap`, обеспечивая возможность их получения по имени.
 */
public class CommandsProvider {

    /**
     * `HashMap`, содержащий доступные команды, где ключ - имя команды, а значение - объект `Command`.
     */
    public static Map<String, Command> commands = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    /**
     * Выполняет поиск команды по введенной пользователем строке и вызывает ее выполнение.
     *
     * @param userLine Строка, введенная пользователем, содержащая имя команды и аргумент (если есть).
     */
    public static void SearchCommand(String userLine) {
        String[] wordsInLine = userLine.split(" ");
        String command = wordsInLine[0];
        try {
            Command command1 = commands.get(command);
            command1.execute(wordsInLine[1]);
        } catch (NullPointerException e) {
            System.out.println("ERROR");
        }
    }

    /**
     * Конструктор класса `CommandsProvider`.
     * Инициализирует `HashMap` с доступными командами.
     */
    public CommandsProvider() {
        commands.put("help", new Help());
        commands.put("info", new Inform());
        commands.put("save", new Saver());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update_id", new Updater());
        commands.put("remove_key", new RemKey());
        commands.put("clear", new Clean());
        commands.put("execute_script", new Scripter());
        commands.put("replace_h", new Replace_Higher());
        commands.put("replace_l", new Replace_Lower());
        commands.put("remove_lower", new RemLow());
        commands.put("min_name", new MinName());
        commands.put("from_max_to_min", new FromMax());
        commands.put("from_min_to_max", new FromMin());
    }

    /**
     * Возвращает объект `Command` по заданному ключу (имени команды).
     *
     * @param key Имя команды.
     * @return Объект `Command` или `null`, если команда не найдена.
     */
    public Command getCommandByKey(String key) {
        return commands.get(key);
    }

    /**
     * Возвращает `HashMap`, содержащий все доступные команды.
     *
     * @return `HashMap`, содержащий все команды.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }
}




