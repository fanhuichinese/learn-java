package org.example.java8.lambda;

public class Test {

    public static void main(String[] args) {
        testMathOperation(10, 5);
        testGreetingService("Alan");
        testConverter(2, 1);
    }

    public static void testMathOperation(int p1, int p2) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println(p1 + " + " + p2 + " = " + Util.operate(p1, p2, addition));
        System.out.println(p1 + " - " + p2 + " = " + Util.operate(p1, p1, subtraction));
        System.out.println(p1 + " * " + p2 + " = " + Util.operate(p1, p1, multiplication));
        System.out.println(p1 + " / " + p2 + " = " + Util.operate(p1, p2, division));
    }

    public static void testGreetingService(String name) {
        GreetingService greetService1 = message -> System.out.println(Util.HELLO + " " + message);
        GreetingService greetService2 = message -> System.out.println(Util.HI + " " + message);

        greetService1.sayMessage(name);
        greetService2.sayMessage(name);
    }

    public static void testConverter(int p1, int num) {
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(p1);
    }

}
