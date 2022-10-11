package com.aping.java8.function;

import java.util.function.Function;

/**
 * <p>
 * FunctionExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/9 21:04
 */
public class FunctionExample {

    public static void main(String[] args) {

        System.out.println(doubleFee("123"));

        System.out.println(getFee("123", s -> Integer.parseInt(s) * 2));
    }

    private static Integer getFee(String str, Function<String, Integer> function) {

        return function.apply(str);
    }


    private static Integer doubleFee(String str) {

        return Integer.parseInt(str) * 2;
    }
}
