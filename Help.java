package Controller.Commands;

import Controller.Command;

/**
 * Класс Help реализует команду вывода справки по доступным командам.
 */
public class Help implements Command {

    /**
     * Возвращает описание команды.
     *
     * @return строка с описанием команды.
     */
    @Override
    public String getDescription() {
        return getName() + " вывести справку по доступным командам";
    }

    /**
     * Возвращает имя команды.
     *
     * @return строка с именем команды.
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Выполняет команду вывода справки по доступным командам.
     *
     * @param arg аргумент команды (в данной реализации не используется).
     */
    @Override
    public void execute(String arg) {
        System.out.println(getDescription());
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add : добавить новый элемент с заданным ключом");
        System.out.println("update_id : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_key : удалить элемент из коллекции по его ключу");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("remove_lower : удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("replace_h : заменить значение по ключу, если новое значение больше старого");
        System.out.println("replace_l : заменить значение по ключу, если новое значение меньше старого");
        System.out.println("min_name : вывести любой объект из коллекции, значение поля name которого является минимальным");
        System.out.println("from_max_to_min : вывести элементы коллекции в порядке убывания");
        System.out.println("from_min_to_max : вывести элементы коллекции в порядке возрастания");
    }
}