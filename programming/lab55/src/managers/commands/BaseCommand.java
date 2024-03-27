package managers.commands;

import managers.CollectionManager;

/**
 * Базовый интерфейс для реализации команд. Такие команды содержаться в CollectionManager
 *
 * @author khizhmsh
 * @see managers.CollectionManager
 * @since 1.0
 */
public interface BaseCommand {
    /**
     * Базовый метод для вывода исполнения команды
     * Выбрасывает ошибки при реализации
     *
     * @author khizhmsh
     * @since 1.0
     */
    public void execute(String[] args, CollectionManager collectionManager) throws Exception;
    /**
     * Базовый метод для вывода названия команды
     *
     * @author khizhmsh
     * @since 1.0
     */

    public String getName();
    /**
     * Базовый метод для вывода описания команды
     *
     * @author khizhmsh
     * @since 1.0
     */

    public String getDescription();
}
