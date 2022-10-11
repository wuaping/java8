package com.aping.java8.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aping
 * @since 2022/9/8 14:32
 */
public class SubList {
    private static final List<String> OLD_LIST = Arrays.asList(
            "唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));

    public static void main(String[] args) {
        // 集合分隔
        // List<String> list = OLD_LIST.subList(0, OLD_LIST.size());
        // 打印集合中的元素
        // list.forEach(System.out::println);


        for (int i = 0; i < OLD_LIST.size(); i += 2) {
            // 集合分隔
            List<String> sub =
                    OLD_LIST.subList(i, Math.min(i + 2, OLD_LIST.size()));
            // 打印集合中的元素
            sub.forEach(System.out::println);
        }
    }

}
