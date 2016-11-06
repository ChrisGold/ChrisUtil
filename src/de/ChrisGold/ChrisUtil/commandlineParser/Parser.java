package de.ChrisGold.ChrisUtil.commandlineParser;

import java.util.*;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class Parser {

    static final String OPTION = "--";
    static final String FLAG = "-";

    public static ParsingResults parse(String[] args) {
        List<String> flags = new ArrayList<>();
        List<String> arguments = new ArrayList<>();
        Map<String, String> options = new HashMap<>();
        int counter = 0;
        for (; counter < args.length; ) {
            String t = args[counter];
            if (t.startsWith(FLAG)) {
                flags.add(t.substring(FLAG.length()));
                counter++;
            } else if (t.startsWith(OPTION)) {
                t = t.substring(OPTION.length());
                String rawArg = args[counter + 1];
                options.put(t, rawArg);
            } else {
                arguments.add(t);
            }
        }
        return new ParsingResults(flags, options, arguments);
    }

}
