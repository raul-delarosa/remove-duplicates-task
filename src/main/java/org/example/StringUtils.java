package org.example;

import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * Removes duplicates from a string.
     * @param source The original string.
     * @return A new string without duplicates.
     * @throws IllegalArgumentException when source is null.
     */
    static String removeDuplicates(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Source cannot be null.");
        }

        Set<Character> cache = new HashSet<>();
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            Character current = source.charAt(i);
            if (cache.add(current)) {
                resultBuilder.append(current);
            }
        }

        return resultBuilder.toString();
    }
}