package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class ReduceExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        // 求余额总和
        BigDecimal totalBalance = userList.parallelStream()
                .reduce(BigDecimal.ZERO, (last, u) -> last.add(u.getBalance()), (m, n) -> m.subtract(n));

        // 求余额总和2
        BigDecimal totalBalance2 = userList.stream()
                .map(User::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 组合名字
        String reduceName = userList.stream()
                .map(User::getName)
                .reduce("", (u1, u2) -> u1 + "|" + u2);


        System.out.println(totalBalance);
        System.out.println(reduceName);
    }

}
