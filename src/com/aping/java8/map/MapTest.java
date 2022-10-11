package com.aping.java8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aping
 * @since 2022/9/13 15:58
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> failCountMap = new HashMap<>();

        failCountMap.put("A", 1);
        failCountMap.remove("B");
        System.out.println(failCountMap.get("A"));
    }
}
