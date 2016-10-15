package com.epam.course.java.se;

import org.junit.Test;

import java.util.Formatter;
import java.util.Locale;

public class FormatterTests {
    @Test
    public void formatters() {
        try (Formatter formatter = new Formatter()) {
            formatter
                    .format(Locale.forLanguageTag("RU"), "Double: %5.3f!\n", 1.22)
                    .format(Locale.forLanguageTag("US"), "Double: %5.3f!\n", 1.22);
            formatter.flush();
            System.out.println(formatter.toString());
        }

        System.out.printf(Locale.forLanguageTag("RU"), "printf Double: %5.3f!\n", 1.22);
        System.out.printf(Locale.forLanguageTag("US"), "printf Double: %5.3f!\n", 1.22);

        System.out.printf("Double: %10.3f, %<+e, int: %d, str: %s, %<s, int: %2$05d", 111.2345, 666, "abc");
    }
}
