package com.aping.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * DistinctExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/10 12:57
 */
public class DistinctExample {

    public static void main(String[] args) {

        // 去重
        List<String> distinct = Stream.of("1", "2", "3", "3")
                .distinct().collect(Collectors.toList());

        distinct.forEach(System.out::println);

    }

}
