package org.example.java8.lambda;

public class Util {

    public final static String HELLO = "Hello";
    public final static String HI = "Hi";

    public static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
