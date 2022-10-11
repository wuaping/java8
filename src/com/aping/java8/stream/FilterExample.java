package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class FilterExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);


        // 过滤年龄
        List<User> filterAge = userList.stream()
                .filter(user -> user.getAge() > 16)
                .collect(Collectors.toList());

        // 过滤年龄再过滤Id
        List<User> filterAgeAndId = userList.stream()
                .filter(user -> user.getAge() > 16)
                .filter(user -> user.getId() < 2)
                .collect(Collectors.toList());

    }

}
