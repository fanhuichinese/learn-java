package org.example.java8.optional;

import java.util.Optional;

public class Test {

    public static void main(String[] args) throws Throwable {
        // testSum(20, 10);
        // testEmpty();
        // testEquals();
        // testFilter();
        // testFlatMap();
        // testGet();
        // testHashCode();
        // testIfPresent();
        // testIsPresent();
        // testMap();
        // testOf();
        // testOfNullable();
        // testOrElse();
        // testOrElseGet();
        // testOrElseThrow();
        testToString();
    }

    public static void testSum(Integer value1, Integer value2) {
        System.out.println(Util.sum(Optional.ofNullable(value1), Optional.of(value2)));
    }

    public static void testEmpty() {
        Optional<Apple> optionalApple = Optional.empty();
        System.out.println(optionalApple.isPresent());
    }

    public static void testEquals() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        Optional<Apple> apple2 = Optional.of(new Apple("苹果2"));
        Optional<Apple> apple3 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.equals(apple2));
        System.out.println(apple1.equals(apple3));
    }

    public static void testFilter() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        Optional<Apple> apple1filter = apple1.filter(Util::filter);
        Util.optionalOut(apple1filter);
        Optional<Apple> apple2 = Optional.of(new Apple("苹果2"));
        Optional<Apple> apple2filter = apple2.filter(Util::filter);
        Util.optionalOut(apple2filter);
    }

    public static void testFlatMap() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        Optional<Banana> banana1 = apple1.flatMap(Util::appleToBanana);
        Util.optionalOut(banana1);
        Optional<Apple> apple2 = Optional.empty();
        Optional<Banana> banana2 = apple2.flatMap(Util::appleToBanana);
        Util.optionalOut(banana2);
    }

    public static void testGet() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.get());
        Optional<Apple> apple2 = Optional.empty();
        System.out.println(apple2.get());
    }

    public static void testHashCode() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.hashCode());
        Optional<Apple> apple2 = Optional.empty();
        System.out.println(apple2.hashCode());
    }

    public static void testIfPresent() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        apple1.ifPresent(Util::consumerApple);
        Optional<Apple> apple2 = Optional.empty();
        apple2.ifPresent(Util::consumerApple);
    }

    public static void testIsPresent() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.isPresent());
        Optional<Apple> apple2 = Optional.empty();
        System.out.println(apple2.isPresent());
    }

    public static void testMap() {
        Optional<Apple> apple1  = Optional.of(new Apple("苹果1"));
        Util.optionalOut(apple1.map(Util::appleToBananaUsing));
        Optional<Apple> apple2 = Optional.of(new Apple("苹果2"));
        Util.optionalOut(apple2.map(Util::appleToBananaUsing));
    }

    public static void testOf() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.get().getName());
    }

    public static void testOfNullable() {
        Optional<Apple> apple1 = Optional.of(null);
        Optional<Apple> apple2 = Optional.ofNullable(null);
    }

    public static void testOrElse() {
        Optional<Apple> apple1 = Optional.ofNullable(new Apple("苹果1"));
        Optional<Apple> apple2 = Optional.ofNullable(null);
        System.out.println(apple1.orElse(new Apple("苹果3")).getName());
        System.out.println(apple2.orElse(new Apple("苹果3")).getName());
    }

    public static void testOrElseGet() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.orElseGet(Util::supplierApple).getName());
        Optional<Apple> apple2 = Optional.empty();
        System.out.println(apple2.orElseGet(Util::supplierApple).getName());
    }

    public static void testOrElseThrow() throws Throwable {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.orElseThrow(Util::supplierException).getName());
        Optional<Apple> apple2 = Optional.empty();
        System.out.println(apple2.orElseThrow(Util::supplierException).getName());
    }

    public static void testToString() {
        Optional<Apple> apple1 = Optional.of(new Apple("苹果1"));
        System.out.println(apple1.toString());
    }

}
