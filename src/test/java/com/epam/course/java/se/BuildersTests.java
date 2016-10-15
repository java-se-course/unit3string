package com.epam.course.java.se;

import org.junit.Test;

import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class BuildersTests {
    @Test
    public void builder() {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String abc = a + b + c + 1;
        System.out.println(abc);

        final String[] strings = {"a", "b", "c"};
        String result = "";
        for (String string : strings) {
            result += string;
        }
        System.out.println(result);

        String resultInts = "";
        for (int i = 0; i < 100; i++) {
            resultInts += ThreadLocalRandom.current().nextInt();
        }
        System.out.println(resultInts);

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(ThreadLocalRandom.current().nextInt());
        }
        System.out.println(stringBuilder.toString());
    }

    private String joinNames(String... names) {
        // [Sara, Bob] -> "Sara and Bob"
//        final StringBuilder result = new StringBuilder();
//        boolean first = true;
//        for (String name : names) {
//            if (first) {
//                result.append(name);
//                first = false;
//            } else {
//                result.append(" and ").append(name);
//            }
//        }
//
//        return result.toString();

        // [Sara, Bob] -> "Names: Sara and Bob!"
        final StringJoiner stringJoiner =
                new StringJoiner(" and ", "Names: ", "!")
                .setEmptyValue("No names");

        for (String name : names) {
            stringJoiner.add(name);
        }

        return stringJoiner.toString();
    }

    @Test
    public void join() {
        final String[] names = {"John", "Marta", "Bob", "Sara"};
        System.out.println(joinNames(names));
        System.out.println(joinNames());
        System.out.println(joinNames("Robert"));
    }


}
