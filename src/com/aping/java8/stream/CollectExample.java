package com.aping.java8.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;

/**
 * @author Aping
 * @since 2022/9/14 16:57
 */
public class CollectExample {

    public static void main(String[] args) {
        User user1 = new User(1L, "A", 18, new BigDecimal("100"));
        User user2 = new User(2L, "B", 16, new BigDecimal("200"));
        User user3 = new User(3L, "C", 22, new BigDecimal("300"));
        User user4 = new User(4L, "D", 15, new BigDecimal("400"));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        /*------------ toList ------------*/
        // 将所有的用户名转为List<name>
        List<String> nameList = userList.stream()
                .map(User::getName)
                .collect(() -> new ArrayList<>(), (list, name) -> list.add(name), (m, n) -> m.addAll(n));

        // 将所有的用户名转为List<name> 简化版
        List<String> nameList2 = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        // List 转 Map<id, User>
        Map<Long, User> idMap = userList.stream()
                .collect(() -> new HashMap<>(), (map, user) -> map.put(user.getId(), user), (m, n) -> m.putAll(n));

        // List 转 Map<id, User> 简化版
        Map<Long, User> idMap2 = userList.stream()
                .collect(Collectors.toMap(User::getId, user -> user));
        /*------------ toList ------------*/


        /*------------ toSet ------------*/
        // 将所有的用户名转为Set<name> 简化版
        Set<String> nameSet = userList.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
        /*------------ toSet ------------*/


        /*------------ toMap ------------*/
        // List 转 Map<id, name>
        Map<Long, String> idNameMap = userList.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        // List 转 Map<name#id, balance>
        Map<String, String> nameIdBalanceMap = userList.stream()
                .collect(Collectors.toMap(user -> user.getName() + "#" + user.getId(), User::getName));
        /*------------ toMap ------------*/


        /*------------ toCollection ------------*/
        // 将结果集合转为 linkedList
        LinkedList<String> linkedList = userList.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        // 将结果集合转为 treeSet
        TreeSet<String> treeSet = userList.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        /*------------ toCollection ------------*/


        /*------------ groupingBy ------------*/
        // 按年龄分组
        Map<Integer, List<User>> ageMap = userList.stream()
                .collect(Collectors.groupingBy(User::getAge));

        // 分组统计非对象（字符串）
        Map<String, Long> strCount = Stream.of("A", "A", "B")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 按年龄分组并统计数量
        Map<Integer, Long> ageCount = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.counting()));

        // 按年龄分组并金额求和
        Map<Integer, BigDecimal> ageSumBalance = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getBalance, reducing(BigDecimal.ZERO, BigDecimal::add))));

        // 按姓名分组并统计年龄平均数
        Map<String, Double> ageAvg = userList.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.averagingInt(User::getAge)));


        // 按年龄分组后对结果转换为Set
        Map<Integer, Set<String>> nameSetGroupByAge = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toSet())));

        // 按年龄分组后，将名字拼接成 [x, y, z] 形式
        Map<Integer, String> nameStrGroupByAge = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.joining(", ", "[", "]"))));

        // 多重分组，按年龄分组后再按姓名分组
        Map<Integer, Map<String, List<User>>> collect = userList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.groupingBy(User::getName, Collectors.toList())));
        /*------------ groupingBy ------------*/


        /*------------ partitioningBy ------------*/
        // 将列表按表达式分区
        Map<Boolean, List<User>> partitioningByAge = userList.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() > 17, Collectors.toList()));
        /*------------ partitioningBy ------------*/

    }

}
