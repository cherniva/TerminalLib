package cherniva.project.TerminalLib;

import java.util.HashMap;

public class OptionManagerImpl implements OptionManager {

    private HashMap<String, Option<?>> optionHashMap;

    public OptionManagerImpl() {
        //deserialize options from file to hash map
    }

    @Override
    public <T> void saveOption(Option<T> option) {
        //save option to file and hashmap
    }

    @Override
    public <T> void saveOption(String name, T argument, String description, OptionConsumer functionality) {
        Option<T> option = new Option<>(name, argument, description, functionality);
        saveOption(option);
    }

    @Override
    public <T> void saveOption(String name, T argument, String description) {
        saveOption(name, argument, description, null);
    }

    @Override
    public void saveOption(String name, String description, OptionConsumer functionality) {
        saveOption(name, null, description, functionality);
    }

    @Override
    public <T> void saveAllAliases(String[] names, T argument, String description, OptionConsumer functionality) {

    }

    @Override
    public void addAlias(String name, String alias) {

    }

    @Override
    public <T> void deleteOption(Option<T> option, boolean deleteAliases) {

    }

    @Override
    public <T> void deleteOption(Option<T> option) {
        deleteOption(option, false);
    }

    @Override
    public void deleteOption(String name, boolean deleteAliases) {

    }

    @Override
    public void deleteOption(String name) {
        deleteOption(name, false);
    }

    @Override
    public <T> void evaluateOption(Option<T> option) {

    }

    @Override
    public void evaluateLine(String line) {

    }

    @Override
    public void defaultOptionSource(String path) {

    }
}
