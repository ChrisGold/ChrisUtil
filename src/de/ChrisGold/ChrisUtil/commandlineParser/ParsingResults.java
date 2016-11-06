package de.ChrisGold.ChrisUtil.commandlineParser;

import java.util.List;
import java.util.Map;

/**
 * @author Chris Gold
 * @version 1.0
 */
public class ParsingResults {
    public final List<String> flags;
    public final Map<String, String> options;
    public final List<String> arguments;

    public ParsingResults(List<String> flags, Map<String, String> options, List<String> arguments) {
        this.flags = flags;
        this.options = options;
        this.arguments = arguments;
    }
}
