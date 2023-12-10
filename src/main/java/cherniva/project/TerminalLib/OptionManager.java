package cherniva.project.TerminalLib;

public interface OptionManager {
    /*
    save new option to file (use default location) probably json
    when options retrieves they placed to list for fast access
     */
    <T> void saveOption(Option<T> option);
    <T> void saveOption(String name, T argument, String description, OptionConsumer functionality);
    <T> void saveOption(String name, T argument, String description);
    void saveOption(String name, String description, OptionConsumer functionality);
    <T> void saveAllAliases(String[] names, T argument, String description, OptionConsumer functionality);
    void addAlias(String name, String alias);
    <T> void deleteOption(Option<T> option, boolean deleteAliases);
    <T> void deleteOption(Option<T> option);
    void deleteOption(String name, boolean deleteAliases);
    void deleteOption(String name);
    <T> void evaluateOption(Option<T> option);
    void evaluateLine(String line);
    void defaultOptionSource(String path);

//    void start();
//    void stop();
}
