package org.example.java8.methodreference;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // testCar();
        // testSystemOut();
        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        map.put(i++, "abc");
        System.out.println(map);
    }

    public static void testCar() {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);

        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

    public static void testSystemOut() {
        List<String> names = new ArrayList<>();
        names.add("砚寒清");
        names.add("墨倾池");
        names.add("默苍离");
        names.forEach(System.out::println);
    }

}
