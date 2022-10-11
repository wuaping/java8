package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class AnyMatchExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 是否存在名字为E
        boolean exit = userList.stream()
                .anyMatch(user -> "E".equals(user.getName()));

        System.out.println(exit);
    }

}
