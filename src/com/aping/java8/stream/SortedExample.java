package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * SortedExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/10 13:05
 */
public class SortedExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 数字排序
        List<Integer> intList = Stream.of(4, 3, 2, 5)
                .sorted()
                .collect(Collectors.toList());

        // user 年龄倒序
        List<User> userSorted = userList.stream()
                .sorted((u1, u2) -> u2.getAge() - u1.getAge())
                .collect(Collectors.toList());

        // 取年龄最小
        User user = userList.stream()
                .min(Comparator.comparingInt(User::getAge)).get();

        PrintList.print(intList);
        System.out.println("------");
        PrintList.print(userSorted);
        System.out.println("------");
        System.out.println(user);
    }


}
