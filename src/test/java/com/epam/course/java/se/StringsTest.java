package com.epam.course.java.se;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void constructors() throws UnsupportedEncodingException {
        assertEquals("", new String());

        assertEquals("value", new String(new String("value")));

        assertEquals("abc", new String(new char[]{'a', 'b', 'c'}));

        assertEquals("b", new String(new char[]{'a', 'b', 'c'}, 1, 1));

        System.out.println(Integer.toBinaryString('A'));
        // 01000001
        // 11000001
        // 11101110
        // 10111111 11111111
        // 11011111 11111111 11111111
        System.out.println(new String(new byte[]{(byte) 0xEE}));
        System.out.println(new String(new byte[]{(byte) 0xEE}, "CP1251"));
        System.out.println(new String(new byte[]{(byte) 0xEE}, "CP866"));
        final String s = "\uD83D\uDE07";
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println(s.codePointAt(0));
        System.out.println(Integer.toHexString(s.codePointAt(0)));
        System.out.println(Integer.toBinaryString(s.codePointAt(0)));
        // 11111011000000111
        System.out.println(s.codePointAt(1));
        System.out.println((int) s.charAt(1));


    }

    @Test
    public void methods() throws UnsupportedEncodingException {
        final String s = "a\uD83D\uDE07b\uD83D\uDE08c\uD83D\uDE09d\uD83D\uDE0Ae\uD83D\uDE0B";
        System.out.println(s);
        System.out.println(s.offsetByCodePoints(0, 2));
        System.out.println(s.substring(s.offsetByCodePoints(0, 2)));
        System.out.println(s.substring(s.offsetByCodePoints(0, 2), s.length()));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointAt(0));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointBefore(1));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointAt(1));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointBefore(2));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointAt(2));
        System.out.println("\uD83D\uDE07\uD83D\uDE08".codePointBefore(3));

        printBytes("\uD83D\uDE07\uD83D\uDE08".getBytes());
        printBytes("abc".getBytes());
        printBytes("Привет!".getBytes());
        printBytes("Привет!".getBytes("CP1251"));
        printBytes("Привет!".getBytes(Charset.forName("CP866")));

    }

    private void printBytes(byte[] str) {
        for (byte b : str) {
            if (b < 0) {
                System.out.print(Integer.toBinaryString(b).substring(3*8));
            } else {
                System.out.print(Integer.toBinaryString(b));
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    @Test
    public void equelses() {
        System.out.println("привет".equalsIgnoreCase("Привет"));
    }

    @Test
    public void intern() {
        final String hi = "Hi!";
        final String hi2 = new String("Hi!");
        System.out.println(hi == hi2.intern());
    }

    @Test
    public void concat() {
        final Integer i = null;
        try {
            i.toString();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(i + "");
        System.out.println(String.format("%s", i));
    }

    @Test
    public void index() {
        final String s = "a\uD83D\uDE07b\uD83D\uDE08c\uD83D\uDE09d\uD83D\uDE0Ae\uD83D\uDE0B";
        System.out.println(s.codePointAt(4));
        System.out.println(s.indexOf(128520));
        System.out.println(s.indexOf('b'));
        System.out.println(s.indexOf('\uD83D'));
        System.out.println(s.lastIndexOf('\uD83D'));
        System.out.println(s.lastIndexOf('\uD83D', 12));
    }

    @Test
    public void methods2() {
        try {
            System.out.println(String.valueOf(null));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(String.format(Locale.forLanguageTag("RU"), "%5.5f", 1.1));
        System.out.println(String.format(Locale.forLanguageTag("US"), "%5.5f", 1.1));

        System.out.println("[abc][abc][abc]");
        System.out.println("bac".matches("[abc][abc][abc]"));
        System.out.println("ba".matches("[abc][abc][abc]"));
        System.out.println("baca".matches("[abc][abc][abc]"));
        System.out.println();

        System.out.println("[abc]*");
        System.out.println("".matches("[abc]*"));
        System.out.println("aaaabbaacc".matches("[abc]*"));
        System.out.println("abcdef".matches("[abc]*"));
        System.out.println();

        System.out.println("[abc]+");
        System.out.println("".matches("[abc]+"));
        System.out.println("aaaabbaacc".matches("[abc]+"));
        System.out.println();

        final String pattern = "[a-zA-Z 0-9]*";
        System.out.println(pattern);
        System.out.println("abcderdvdfasldkfhasj".matches(pattern));
        System.out.println("abcderdvdfas 1ldkfhasj".matches(pattern));
        System.out.println();

        for (String s : "Мама   мыла   раму".split(" +", 20)) {
            System.out.println(s);
        }
    }

}
