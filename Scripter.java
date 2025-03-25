package Controller.Commands;

import Controller.Command;
import Controller.CommandsProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Класс Scripter реализует команду выполнения скрипта из указанного файла.
 */
public class Scripter implements Command {

    // Множество для отслеживания выполняемых скриптов (для предотвращения рекурсии)
    private static final Set<String> executedScripts = new HashSet<>();

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "execute_script";
    }

    /**
     * Выполняет команду выполнения скрипта из указанного файла.
     *
     * @param arg аргумент команды, представляющий путь к файлу скрипта.
     */
    @Override
    public void execute(String arg) {
        String filePath = arg;
        CommandsProvider commandsProvider = new CommandsProvider();

        // Проверка на рекурсию
        if (executedScripts.contains(filePath)) {
            System.err.println("Обнаружена рекурсия при выполнении скрипта: " + filePath);
            return;
        }

        // Добавляем текущий скрипт в множество выполняемых
        executedScripts.add(filePath);

        try (Scanner scan = new Scanner(new File(filePath))) {
            while (scan.hasNextLine()) {
                String text = scan.nextLine().trim();
                if (text.isEmpty()) {
                    continue; // Пропускаем пустые строки
                }

                // Разделяем строку на команду и аргумент
                String[] request = text.split(" ", 2);
                String commandName = request[0].trim();
                String argument = request.length > 1 ? request[1].trim() : "";

                // Если команда - это вызов другого скрипта, проверяем на рекурсию
                if (commandName.equals(getName())) {
                    if (executedScripts.contains(argument)) {
                        System.err.println("Обнаружена рекурсия: скрипт " + argument + " уже выполняется.");
                        continue;
                    }
                }

                // Получаем команду по имени и выполняем её
                Command command = commandsProvider.getCommandByKey(commandName);
                if (command != null) {
                    command.execute(argument);
                } else {
                    System.err.println("Неизвестная команда: " + commandName);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } finally {
            // Удаляем текущий скрипт из множества выполняемых
            executedScripts.remove(filePath);
        }
    }
}