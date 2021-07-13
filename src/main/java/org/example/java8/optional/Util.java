package org.example.java8.optional;

import java.util.Optional;
import java.util.Random;

public class Util {

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        Integer value1 = a.orElse(0);
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static boolean filter(Apple apple) {
        return apple.getName().contains("1");
    }

    public static void optionalOut(Optional optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get().toString());
        } else {
            System.out.println("不存在");
        }
    }

    public static Optional<Banana> appleToBanana(Apple apple) {
        return Optional.of(new Banana(apple.getName().replace("苹果", "香蕉")));
    }

    public static void consumerApple(Apple apple) {
        System.out.println("consumerApple " + apple.getName());
    }

    public static Banana appleToBananaUsing(Apple apple) {
        if (apple.getName().contains("1")) {
            return new Banana("香蕉1");
        }
        return null;
    }

    public static Apple supplierApple() {
        return new Apple("苹果" + new Random().nextInt(100));
    }

    public static Throwable supplierException() {
        return new Throwable("自定义的异常");
    }

}
