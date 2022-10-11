package com.aping.java8.uuid;

import java.util.UUID;

/**
 * @author Aping
 * @since 2022/9/4 11:42
 */
public class UuidGenerate {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }

}
