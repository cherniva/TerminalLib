package cherniva.project.TerminalLib;

import java.io.Serializable;
import java.util.HashMap;

public class Option<T> implements Serializable {
    private final String optionName;
    private T optionArgument;
    private final String optionDescription;
    private final OptionConsumer optionFunctionality;

    /*
    private final ArrayList<String> aliases;
    private final nullValueAfterCall;
    private final int minValue;
    private final int maxValue;
    private final String minValue;
    private final String maxValue;
     */

    public Option(String optionName, T optionArgument, String optionDescription, OptionConsumer optionFunctionality) {
        this.optionName = optionName;
        this.optionArgument = optionArgument;
        this.optionDescription = optionDescription;
        this.optionFunctionality = optionFunctionality;
    }

    public Option(String optionName, String optionDescription, OptionConsumer optionFunctionality) {
        this(optionName, null, optionDescription, optionFunctionality);
    }

    public Option(String optionName, T optionArgument, String optionDescription) {
        this(optionName, optionArgument, optionDescription, null);
    }

    public void doJob(HashMap<String, Option<?>> arguments) {
        optionFunctionality.accept(arguments);
    }

    public void doJob() {
        optionFunctionality.accept(null);
    }

    public String getOptionName() {
        return optionName;
    }

    public T getOptionArgument() {
        return optionArgument;
    }

    public void setOptionArgument(T optionArgument) {
        this.optionArgument = optionArgument;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public boolean isFunctionalityNotNull() {
        return this.optionFunctionality != null;
    }
}
