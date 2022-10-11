package com.aping.java8.function;

import com.aping.java8.stream.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 * PredicateExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/9 21:11
 */
public class PredicateExample {

    public static void main(String[] args) {

        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 18, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 25, new BigDecimal("400"));

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println(containName(userList, "A"));

        System.out.println(containSomeOne(userList, user -> user.getId() == 3L));
    }

    public static boolean containSomeOne(List<User> userList, Predicate<User> predicate) {
        for (User user : userList) {
            if (predicate.test(user)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containName(List<User> userList, String name) {
        for (User user : userList) {
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

}
