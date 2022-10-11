package com.aping.java8.function;

import com.aping.java8.stream.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * LambadaExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/9 21:54
 */
public class LambadaExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 10, new BigDecimal("400"));
        User user2 = new User(2L, "B", 18, new BigDecimal("300"));
        User user3 = new User(3L, "C", 13, new BigDecimal("200"));
        User user4 = new User(4L, "D", 3, new BigDecimal("100"));

        List<User> userList = Arrays.asList(user1, user2,user3, user4);

        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        userList.sort((User u1, User u2) -> {
            return u2.getAge() - u1.getAge();
        });

        userList.sort((u1, u2) -> {
            return u2.getAge() - u1.getAge();
        });

        userList.sort((u1, u2) ->
            u2.getAge() - u1.getAge()
        );

        userList.forEach(user -> System.out.println(user.toString()));
    }
}
