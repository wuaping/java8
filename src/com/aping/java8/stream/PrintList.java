package com.aping.java8.stream;

import java.util.List;

/**
 * <p>
 * 打印列表
 * </p>
 *
 * @author Aping
 * @since 2022/10/10 13:06
 */
public class PrintList {

    public static <T> void print(List<T> list) {
        list.forEach(item -> System.out.println(item.toString()));
    }

}
