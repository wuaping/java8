package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class ForEachPeekMapExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 用forEach  age += 1
        userList.forEach(user -> user.setAge(user.getAge() + 1));

        // 用peek  age += 1
        List<User> peek = userList.stream()
                .peek(user -> user.setAge(user.getAge() + 1))
                .collect(Collectors.toList());

        // 用map  age += 1
        List<User> map = userList.stream()
                .map(user -> {
                    user.setAge(user.getAge() + 1);
                    return user;
                }).collect(Collectors.toList());

        // map string转int
        List<Integer> mapInt = Stream.of("1", "2", "3")
                .map(Integer::parseInt).collect(Collectors.toList());
    }

}
