package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class FindAnyExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "D", 16, new BigDecimal("200"));
        User user3 = new User(3L, "D", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        long t = 0L;
        // 任意获取流中某个的用户
        for (int i = 0; i < 100000; i++){
            User find = userList.parallelStream()
                    .findAny().get();
            if (i == 0){
                t = find.getId();
            }else {
                if (t != find.getId()){
                    System.out.println("findAny不稳定");
                }
            }
        }

        System.out.println("----");

        // 任意获取流中第一个的用户
        for (int i = 0; i < 100000; i++){
            User find2 = userList.parallelStream()
                    .findFirst().get();
            if (i == 0){
                t = find2.getId();
            }else {
                if (t != find2.getId()){
                    System.out.println("findFirst不稳定");
                }
            }
        }
    }

}
