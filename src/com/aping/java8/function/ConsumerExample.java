package com.aping.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * ConsumerExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/9 20:51
 */
public class ConsumerExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C");

        printLow(list);

        printList(list, s -> System.out.println(s.toLowerCase()));
    }

    private static void printList(List<String> list, Consumer<String> consumer) {
        for (String str : list) {
            consumer.accept(str);
        }
    }


    private static void printLow(List<String> list) {
        for (String str : list) {
            System.out.println(str.toLowerCase());
        }
    }

}
