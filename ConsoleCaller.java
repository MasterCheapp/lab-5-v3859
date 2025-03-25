package Controller;

import java.util.Scanner;

/**
 * Класс `ConsoleCaller` обрабатывает ввод команд из консоли и вызывает соответствующие команды для выполнения.
 */
public class ConsoleCaller {
    Scanner scanner = new Scanner(System.in);
    CommandsProvider commandsProvider;

    /**
     * Конструктор класса `ConsoleCaller`.
     *
     * @param commandsProvider Объект `CommandsProvider`, предоставляющий доступ к доступным командам.
     */
    public ConsoleCaller(CommandsProvider commandsProvider) {
        this.commandsProvider = commandsProvider;
    }

    /**
     * Запускает основной цикл обработки команд из консоли.  Ожидает ввода команды,
     * обрабатывает ее и вызывает соответствующую команду для выполнения.
     * Цикл продолжается до тех пор, пока пользователь не введет команду "exit".
     */
    public void Call() {
        while (true) {
            System.out.println("Введите команду");
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                break;
            }
            String[] request = text.split(" ");
            String argument = "";
            if (request.length > 1) {
                argument = request[1].trim();
            }

            try {
                Command command1 = commandsProvider.getCommandByKey(request[0]);
                command1.execute(argument);
            } catch (NullPointerException e) {
                System.out.println("ERROR");
            }
        }
    }
}
