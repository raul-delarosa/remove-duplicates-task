package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class RemoveDuplicates {

        @Test
        @DisplayName("When source is null then throw exception.")
        void source_is_null() {
            assertThrows(
                IllegalArgumentException.class,
                () -> StringUtils.removeDuplicates(null)
            );
        }

        @Test
        @DisplayName("When source is empty then return empty string.")
        void source_is_empty() {
            String source = "";
            String expected = "";

            String actual = StringUtils.removeDuplicates(source);

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("When source doesn't have duplicates return unmodified string.")
        void source_contains_no_duplicates() {
            String[] cases = new String[] {"a", "ab", "abc"};

            for (String expected : cases) {
                String actual = StringUtils.removeDuplicates(expected);
                assertEquals(expected, actual);
            }
        }

        @Test
        @DisplayName("When source has duplicates return string without duplicates.")
        void source_contains_duplicates() {
            String[] source = new String[] {
                "aa",
                "aabb",
                "aabccb",
                "AABBCCD112233"
            };

            String[] expected = new String[] {
                "a",
                "ab",
                "abc",
                "ABCD123"
            };

            for (int i = 0; i < source.length; i++) {
                String actual = StringUtils.removeDuplicates(source[i]);
                assertEquals(expected[i], actual);
            }
        }
    }
}