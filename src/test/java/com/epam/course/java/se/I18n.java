package com.epam.course.java.se;

import org.junit.Test;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Simon Popugaev
 */
public class I18n {

    @Test
    public void incorrect_i18n() {

        final String name = getName();
        final String greeting = getGreeting();
        final String message = greeting + " " + name + "!";

        System.out.println(message);
    }

    private String getGreeting() {
        return "Hello";
    }

    private String getName() {
        return "Bob";
    }

    @Test
    public void i18n_number() {
        final Locale defaultLocale = Locale.getDefault();
        System.out.println(NumberFormat.getNumberInstance(Locale.CHINESE).format(1.2));
    }

    @Test
    public void i18n_date() {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy EEEE");
        System.out.println(dateTimeFormatter.withLocale(new Locale("ru", "RU")).format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.withLocale(Locale.CHINA).format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.withLocale(Locale.CHINESE).format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.withLocale(Locale.SIMPLIFIED_CHINESE).format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.withLocale(Locale.TRADITIONAL_CHINESE).format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter.withLocale(new Locale("iw", "IL")).format(LocalDateTime.now()));
    }
}
