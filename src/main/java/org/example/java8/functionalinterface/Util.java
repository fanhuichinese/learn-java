package org.example.java8.functionalinterface;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public class Util {

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }
    }

    public static String wisdom(String name) {
        return "这个智者是 " + name + "！";
    }

    public static void confidence(int p1) {
        System.out.println("输入的数字是 " + p1);
    }

    public static boolean excellent(int p1) {
        return p1 == 100;
    }

    public static int sagacity() {
        return LocalDateTime.now().getDayOfMonth();
    }

    public static long stringent(int p1) {
        return p1;
    }

    public static int smart(int p1) {
        return p1 << 3;
    }

    public static void graceful(long p1) {
        System.out.println("我的智商是：" + p1);
    }

    public static String beautiful(long p1) {
        return "输入的数字是：" + p1;
    }

    public static boolean healthy(long p1) {
        return p1 > 0;
    }

    public static double well(long p1) {
        return p1 + 0.0;
    }

    public static int peculiar(long p1) {
        return (int) p1;
    }

    public static long dashing(long p1) {
        return p1 * p1;
    }

    public static void handsome(String t, double value) {
        System.out.println(t + "：" + value);
    }

    public static void colourful(String t, long value) {
        System.out.println("colourful " + t + " " + value);
    }

    public static void calm(String t, int value) {
        System.out.println("calm " + t + " " + value);
    }

    public static boolean flexible(Boolean p1) {
        return p1;
    }

    public static double nimble(String p1, String p2) {
        System.out.println("nimble "  + p1 + " " + p2);
        return 0D;
    }

}
