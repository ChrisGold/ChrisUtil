package de.ChrisGold.ChrisUtil.commandlineParser;

import java.util.List;
import java.util.Map;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class ParsingResults {
    /**
     * All found flags
     */
    public final List<String> flags;
    /**
     * All found options
     */
    public final Map<String, String> options;
    /**
     * All found arguments
     */
    public final List<String> arguments;

    public ParsingResults(List<String> flags, Map<String, String> options, List<String> arguments) {
        this.flags = flags;
        this.options = options;
        this.arguments = arguments;
    }
}
