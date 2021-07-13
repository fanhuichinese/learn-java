package org.example.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        // testStream(Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"));
        // testForEach(10);
        // testMap(Arrays.asList(3, 2, 2, 3, 7, 3, 5));
        // testFilter(Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"));
        // testLimit(10);
        // testSorted(10);
        // testParallelStream(Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"));
        // testCollectors(Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"));
        // testStatistics(Arrays.asList(3, 2, 2, 3, 7, 3, 5));
        testAll(Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl"),
                Arrays.asList(3, 2, 2, 3, 7, 3, 5),
                Arrays.asList(1,2,13,4,15,6,17,8,19),
                10);
    }

    /**
     * 生成流
     * @param strings
     */
    public static void testStream(List<String> strings) {
        System.out.println(strings);
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }

    /**
     * forEach
      * @param maxSize
     */
    public static void testForEach(long maxSize) {
        new Random().ints().limit(maxSize).forEach(System.out::println);
    }

    /**
     * map
     * @param numbers
     */
    public static void testMap(List<Integer> numbers) {
        System.out.println(numbers);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
    }

    /**
     * filter
     * @param strings
     */
    public static void testFilter(List<String> strings) {
        System.out.println(strings);
        System.out.println(strings.stream().filter(string -> !string.isEmpty()).count());
    }

    /**
     * limit
     * @param maxSize
     */
    public static void testLimit(long maxSize) {
        new Random().ints().limit(maxSize).forEach(System.out::println);
    }

    /**
     * sorted
     * @param maxSize
     */
    public static void testSorted(long maxSize) {
        new Random().ints().limit(maxSize).sorted().forEach(System.out::println);
    }

    /**
     * parallelStream
     * @param strings
     */
    public static void testParallelStream(List<String> strings) {
        System.out.println(strings);
        System.out.println(strings.parallelStream().filter(string -> !string.isEmpty()).count());
    }

    /**
     * Collectors
     * @param strings
     */
    public static void testCollectors(List<String> strings) {
        System.out.println("原列表：" + strings);
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * statistics
     * @param numbers
     */
    public static void testStatistics(List<Integer> numbers) {
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public static void testAll(List<String> strings, List<Integer> numbers, List<Integer> integers, long maxSize) {
        System.out.println("原字符串列表: " + strings);
        System.out.println("空字符串数量为: " + strings.stream().filter(String::isEmpty).count());
        System.out.println("字符串长度为 3 的数量为: "
                + strings.stream().filter(string -> string.length() == 3).count());
        System.out.println("筛选后的非空字符串列表: "
                + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()));
        System.out.println("合并字符串: "
                + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("，")));
        System.out.println("原数字列表：" + numbers);
        System.out.println("平方后的列表："
                + numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList()));
        System.out.println("原整数列表：" + integers);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");
        new Random().ints().limit(maxSize).forEach(System.out::println);
        System.out.println("并行处理");
        System.out.println("空字符串的数量为: " + strings.parallelStream().filter(String::isEmpty).count());
    }

}
