package org.example.java8.functionalinterface;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // testPredicate(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // testRunnable();
        // testCallable();
        // testComputeIfAbsent();
        // testComparator(10);
        // testFileFilter();
        // testBiConsumer("张三", 3000, (t, u) -> System.out.println(t + "抢了别人" + u + "元！"));
        // testBiFunction("漠漠", 100, (t, u) -> t + "考了" + u + "分");
        // testBinaryOperator(2, 3, (t, u) -> t * t + u * u);
        // testBiPredicate(99, 100, (t, u) -> t < u);
        // testBooleanSupplier(() -> true);
        // testConsumer("漠漠", System.out::println);
        // testDoubleBinaryOperator(1.2, 2.3, Double::sum);
        // testDoubleConsumer(0.11, System.out::println);
        // testDoubleFunction(-1.1, value -> value * value);
        // testDoublePredicate(4.11, v -> v > 3);
        // testDoubleSupplier(new Random()::nextDouble);
//        testDoubleToIntFunction(3.1415, v -> {
//            String vs = v + "";
//            int lastIndex = vs.lastIndexOf(".");
//            return Integer.parseInt(vs.substring(0, lastIndex));
//        });
//        testDoubleToLongFunction(123.45, v -> {
//            String vs = v + "";
//            int lastIndex = vs.lastIndexOf('.');
//            return Long.parseLong(vs.substring(0, lastIndex));
//        });
        // testDoubleUnaryOperator(1.6, o -> o * o);
        // testFunction("砚寒清", Util::wisdom);
        // testIntBinaryOperator(1, 2, Integer::sum);
        // testIntConsumer(240, Util::confidence);
        // testIntFunction(-1000, Math::abs);
        // System.out.println("是否考了100分：" + testIntPredicate(100, Util::excellent));
        // testIntSupplier(Util::sagacity);
        // testIntToDoubleFunction(100, Math::sqrt);
        // testIntToLongFunction(1000, Util::stringent);
        // testIntUnaryOperator(3, Util::smart);
        // testLongBinaryOperator(100, 1, Long::sum);
        // testLongConsumer(180, Util::graceful);
        // testLongFunction(123, Util::beautiful);
        // testLongPredicate(-1, Util::healthy);
        // testLongSupplier(System::currentTimeMillis);
        // testLongToDoubleFunction(101, Util::well);
        // testLongToIntFunction(45, Util::peculiar);
        // testLongUnaryOperator(5, Util::dashing);
        // testObjDoubleConsumer("墨倾池", 234.0, Util::handsome);
        // testObjLongConsumer("砚寒清", 100, Util::colourful);
        // testObjIntConsumer("慕容宁", 150, Util::calm);
        // testPredicate(true, Util::flexible);
        // testSupplier(LocalDateTime::now);
        // testToDoubleBiFunction("欲星移", "默苍离", Util::nimble);
        // testToDoubleFunction(10000, Math::sqrt);
        // testToIntBiFunction(100, 300, Integer::sum);
        // testToIntFunction(-123, Math::abs);
        // testToLongBiFunction(200, 300, Long::sum);
        // testToLongFunction(-123456, Math::abs);
        testUnaryOperator(-12345678, Math::abs);
    }

    public static void testPredicate(List<Integer> list) {
        System.out.println("输出所有数据：");
        Util.eval(list, n -> true);
        System.out.println("输出所有偶数:");
        Util.eval(list, n -> n % 2 == 0);
        System.out.println("输出大于 3 的所有数字:");
        Util.eval(list, n -> n > 3);
    }

    public static void testRunnable() {
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int index = i;
            list.add(() -> {
                for (int j = 0; j < 347483647; j++) {
                    Arrays.asList(j);
                }
                System.out.println(index + "--" + new Date());
            });
        }
        list.forEach(l -> new Thread(l).start());
    }

    public static void testCallable() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            int index = i;
            FutureTask task = new FutureTask(() -> {
                for (int j = 0; j < 347483647; j++) {
                    Arrays.asList(j);
                }
                String result = index + "--" + new Date();
                System.out.println("执行中 " + result);
                return "返回值 " + result;
            });
            new Thread(task).start();
        }
    }

    public static void testComputeIfAbsent() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = map.computeIfAbsent("a", k -> Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()));
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(map.get("a"));
    }

    public static void testComparator(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(1000));
        }
        System.out.println("原序列：" + list);
        list.sort((a, b) -> b - a);
        System.out.println("由大到小排序后的序列：" + list);
        list.sort(Comparator.comparingInt(a -> a));
        System.out.println("由小到大排序后的序列：" + list);
    }

    public static void testFileFilter() {
        File dir = new File("D:\\");
        System.out.println("所有文件：");
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            System.out.println(file);
        }
        System.out.println("只有目录：");
        for (File file : Objects.requireNonNull(dir.listFiles(File::isDirectory))) {
            System.out.println(file);
        }
    }

    public static void testBiConsumer(String t, Integer u, BiConsumer<String, Integer> biConsumer) {
        biConsumer.accept(t, u);
    }

    public static void testBiFunction(String t, Integer u, BiFunction<String, Integer, String> biFunction) {
        System.out.println(biFunction.apply(t, u));
    }

    public static void testBinaryOperator(Integer t, Integer u, BinaryOperator<Integer> binaryOperator) {
        System.out.println(binaryOperator.apply(t, u));
    }

    public static void testBiPredicate(Integer t, Integer u, BiPredicate<Integer, Integer> biPredicate) {
        System.out.println(biPredicate.test(t, u));
    }

    public static void testBooleanSupplier(BooleanSupplier booleanSupplier) {
        System.out.println(booleanSupplier.getAsBoolean());
    }

    public static void testConsumer(Object t, Consumer<Object> consumer) {
        consumer.accept(t);
    }

    public static void testDoubleBinaryOperator(Double t, Double u, DoubleBinaryOperator doubleBinaryOperator) {
        System.out.println(doubleBinaryOperator.applyAsDouble(t, u));
    }

    public static void testDoubleConsumer(Double value, DoubleConsumer doubleConsumer) {
        doubleConsumer.accept(value);
    }

    public static void testDoubleFunction(Double value, DoubleFunction<Double> doubleFunction) {
        System.out.println(doubleFunction.apply(value));
    }

    public static void testDoublePredicate(double value, DoublePredicate doublePredicate) {
        System.out.println(doublePredicate.test(value));
    }

    public static void testDoubleSupplier(DoubleSupplier doubleSupplier) {
        System.out.println(doubleSupplier.getAsDouble());
    }

    public static void testDoubleToIntFunction(double value, DoubleToIntFunction doubleToIntFunction) {
        System.out.println(doubleToIntFunction.applyAsInt(value));
    }

    public static void testDoubleToLongFunction(double value, DoubleToLongFunction doubleToLongFunction) {
        System.out.println(doubleToLongFunction.applyAsLong(value));
    }

    public static void testDoubleUnaryOperator(double operand, DoubleUnaryOperator doubleUnaryOperator) {
        System.out.println(doubleUnaryOperator.applyAsDouble(operand));
    }

    public static void testFunction(String t, Function<String, String> function) {
        System.out.println(function.apply(t));
    }

    public static void testIntBinaryOperator(int left, int right, IntBinaryOperator intBinaryOperator) {
        System.out.println(intBinaryOperator.applyAsInt(left, right));
    }

    public static void testIntConsumer(int value, IntConsumer intConsumer) {
        intConsumer.accept(value);
    }

    public static void testIntFunction(int value, IntFunction<Integer> intFunction) {
        System.out.println(intFunction.apply(value));
    }

    public static boolean testIntPredicate(int value, IntPredicate intPredicate) {
        return intPredicate.test(value);
    }

    public static void testIntSupplier(IntSupplier intSupplier) {
        System.out.println(intSupplier.getAsInt());
    }

    public static void testIntToDoubleFunction(int value, IntToDoubleFunction intToDoubleFunction) {
        System.out.println(intToDoubleFunction.applyAsDouble(value));
    }

    public static void testIntToLongFunction(int value, IntToLongFunction intToLongFunction) {
        System.out.println(intToLongFunction.applyAsLong(value));
    }

    public static void testIntUnaryOperator(int operand, IntUnaryOperator intUnaryOperator) {
        System.out.println(intUnaryOperator.applyAsInt(operand));
    }

    public static void testLongBinaryOperator(long left, long right, LongBinaryOperator longBinaryOperator) {
        System.out.println(longBinaryOperator.applyAsLong(left, right));
    }

    public static void testLongConsumer(long value, LongConsumer longConsumer) {
        longConsumer.accept(value);
    }

    public static void testLongFunction(long value, LongFunction<String> longFunction) {
        System.out.println(longFunction.apply(value));
    }

    public static void testLongPredicate(long value, LongPredicate longPredicate) {
        System.out.println(longPredicate.test(value));
    }

    public static void testLongSupplier(LongSupplier longSupplier) {
        System.out.println(longSupplier.getAsLong());
    }

    public static void testLongToDoubleFunction(long value, LongToDoubleFunction longToDoubleFunction) {
        System.out.println(longToDoubleFunction.applyAsDouble(value));
    }

    public static void testLongToIntFunction(long value, LongToIntFunction longToIntFunction) {
        System.out.println(longToIntFunction.applyAsInt(value));
    }

    public static void testLongUnaryOperator(long operand, LongUnaryOperator longUnaryOperator) {
        System.out.println(longUnaryOperator.applyAsLong(operand));
    }

    public static void testObjDoubleConsumer(String t, double value, ObjDoubleConsumer<String> objDoubleConsumer) {
        objDoubleConsumer.accept(t, value);
    }

    public static void testObjLongConsumer(String t, long value, ObjLongConsumer<String> objLongConsumer) {
        objLongConsumer.accept(t, value);
    }

    public static void testObjIntConsumer(String t, int value, ObjIntConsumer<String> objIntConsumer) {
        objIntConsumer.accept(t, value);
    }

    public static void testPredicate(Boolean t, Predicate<Boolean> predicate) {
        System.out.println(predicate.test(t));
    }

    public static void testSupplier(Supplier<LocalDateTime> supplier)  {
        System.out.println(supplier.get());
    }

    public static void testToDoubleBiFunction(String t, String u, ToDoubleBiFunction<String, String> toDoubleBiFunction) {
        System.out.println(toDoubleBiFunction.applyAsDouble(t, u));
    }

    public static void testToDoubleFunction(Integer value, ToDoubleFunction<Integer> toDoubleFunction) {
        System.out.println(toDoubleFunction.applyAsDouble(value));
    }

    public static void testToIntBiFunction(Integer t, Integer u, ToIntBiFunction<Integer, Integer> toIntBiFunction) {
        System.out.println(toIntBiFunction.applyAsInt(t, u));
    }

    public static void testToIntFunction(int value, ToIntFunction<Integer> toIntFunction) {
        System.out.println(toIntFunction.applyAsInt(value));
    }

    public static void testToLongBiFunction(long t, long u, ToLongBiFunction<Long, Long> toLongBiFunction) {
        System.out.println(toLongBiFunction.applyAsLong(t, u));
    }

    public static void testToLongFunction(long value, ToLongFunction<Long> toLongFunction) {
        System.out.println(toLongFunction.applyAsLong(value));
    }

    public static void testUnaryOperator(long t, UnaryOperator<Long> unaryOperator) {
        System.out.println(unaryOperator.apply(t));
    }

}

