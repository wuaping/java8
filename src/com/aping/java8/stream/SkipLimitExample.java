package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * SkipLimitExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/10 13:22
 */
public class SkipLimitExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));


        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 忽略前2条
        List<User> skip = userList.stream()
                .skip(2)
                .collect(Collectors.toList());

        // 只取前1条
        List<User> limit = userList.stream()
                .limit(1)
                .collect(Collectors.toList());

        // 忽略前2条后只取前1条
        List<User> skipAndLimit = userList.stream()
                .skip(2)
                .limit(1)
                .collect(Collectors.toList());


        PrintList.print(skip);
        PrintList.print(limit);
        PrintList.print(skipAndLimit);
    }


}
