package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * StreamExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/11 12:49
 */
public class StreamExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 求出每个年龄余额最大的用户
        Map<Integer, Optional<User>> ageMaxBalance1 = userList.stream()
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.maxBy(Comparator.comparing(User::getBalance))));

        Map<Integer, User> ageMaxBalance2 = userList.stream()
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(User::getBalance)), Optional::get)));

        Map<Integer, User> ageMaxBalance3 = userList.stream()
                .collect(Collectors.toMap(User::getAge,
                        Function.identity(), BinaryOperator.maxBy(Comparator.comparing(User::getBalance))));




    }


}
