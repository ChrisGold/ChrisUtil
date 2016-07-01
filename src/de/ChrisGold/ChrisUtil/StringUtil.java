package de.ChrisGold.ChrisUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class StringUtil {
    /**
     * Given a string, returns an array of all its substrings
     *
     * @param s A string
     * @return An array of all the substrings of s
     */
    public static List<String> allSubstrings(String s) {
        ArrayList<String> strings = new ArrayList<>();
        //For position in the string
        for (int i = 0; i < s.length(); i++) {
            //Take all strings after it
            for (int j = i; j < s.length(); j++) {
                strings.add(s.substring(i, j + 1));
            }
        }
        //We need to add the empty string
        strings.add("");
        //Optimize memory size
        strings.trimToSize();
        return strings;
    }
}
