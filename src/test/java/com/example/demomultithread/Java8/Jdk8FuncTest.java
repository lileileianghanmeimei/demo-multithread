package com.example.demomultithread.Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Jdk8FuncTest {
    public static void main(String[] args) {
        Jdk8FuncTest test = new Jdk8FuncTest();
        List<String> list = Arrays.asList("a","b","c");
        String name = "xiazhang";
        test.convert(list, i -> i.toUpperCase());
        test.convertStr(name, String::toUpperCase);
    }

    public <T,R> void convert(List<T> list, Function<T,R> func){
        List<R> result = new ArrayList<>();
        list.forEach(t -> result.add(func.apply(t)));
        result.forEach(t -> System.out.println(t));
    }

    public <T,R> void convertStr(T t, Function<T,R> function){
        System.out.println(function.apply(t));
    }


    /**
     * T -> T
     *
     *  BiFunction<T,U,R>	    T,U -> R
     *  DoubleFunction<R>	    double -> R
     *  IntFunction<R>	        int -> R
     *  LongFunction<R>	        long -> R
     *  ToDoubleFunction<T>	    T -> double
     *  ToIntFunction<T>	    T -> int
     *  ToLongFunction<T>	    T -> long
     *  DoubleToIntFunction	    double -> int
     *  DoubleToLongFunction	double -> long
     */
    @Test
    public void testFunction(){
        DoubleFunction<String> doubleFunction = d -> "DoubleFunction："+(d + 10);
        System.out.println(doubleFunction.apply(15));

        IntFunction<String> intFunction = i -> "IntFunction："+(i + 10);
        System.out.println(intFunction.apply(20));

        LongFunction<String> longFunction = l -> "LongFunction："+(l + 10);
        System.out.println(longFunction.apply(25));


        ToDoubleFunction<Integer> toDoubleFunction = i -> i + 50;
        System.out.println(toDoubleFunction.applyAsDouble(10));

        ToIntFunction<Long> toIntFunction = l -> Integer.valueOf(String.valueOf(l + 60));
        System.out.println(toIntFunction.applyAsInt(10L));

        ToLongFunction<Integer> toLongFunction = i -> Long.valueOf(i + 20);
        System.out.println(toLongFunction.applyAsLong(60));

        DoubleToIntFunction doubleToIntFunction = d -> (int) (d+30);
        System.out.println(doubleToIntFunction.applyAsInt(50));

        DoubleToLongFunction doubleToLongFunction = d -> (long) (d+60);
        System.out.println(doubleToLongFunction.applyAsLong(30));
    }

    /**
     * T -> boolean
     *
     *  IntPredicate    int -> boolean
     *  LongPredicate   Long -> boolean
     *  DoublePredicate Double -> boolean
     */
    @Test
    public void testPredicate(){
        Predicate<String> predicate = s -> s == "xiazhang";
        System.out.println(predicate.test("xia"));

        IntPredicate intPredicate = i -> i == 10;
        System.out.println(intPredicate.test(10));

        LongPredicate longPredicate = l -> l == 500L;
        System.out.println(longPredicate.test(500));

        DoublePredicate doublePredicate = d -> d == 100D;
        System.out.println(doublePredicate.test(100));
    }

    /**
     * T -> void
     *
     * IntConsumer      int -> void
     * LongConsumer     Long -> void
     * DoubleConsumer   Double -> void
     */
    @Test
    public void testConsumer(){
        Consumer<String> consumer = s -> System.out.println("consumer:" + s);
        consumer.accept("xiazhang");

        IntConsumer intConsumer = i -> System.out.println(i);
        intConsumer.accept(100);

        LongConsumer longConsumer = l -> System.out.println(l);
        longConsumer.accept(200L);

        DoubleConsumer doubleConsumer = d -> System.out.println(d);
        doubleConsumer.accept(300D);
    }

    /**
     * void -> T
     *
     * BooleanSupplier  返回boolean
     * IntSupplier      返回boolean
     * LongSupplier     返回boolean
     * DoubleSupplier   返回boolean
     */
    @Test
    public void testSupplier(){
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());

        IntSupplier intSupplier = () -> 100;
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier = () -> 200L;
        System.out.println(longSupplier.getAsLong());

        DoubleSupplier doubleSupplier = () -> 300D;
        System.out.println(doubleSupplier.getAsDouble());
    }

    /**
     * T -> T
     *
     *  IntUnaryOperator        int -> int
     *  LongUnaryOperator       Long -> Long
     *  DoubleUnaryOperator     Double -> Double
     */
    @Test
    public void testUnaryOperator(){
        UnaryOperator<String> unaryOperator = s -> "UnaryOperator: " + s;
        System.out.println(unaryOperator.apply("xia"));

        IntUnaryOperator intUnaryOperator = i -> i + 100;
        System.out.println(intUnaryOperator.applyAsInt(5));

        LongUnaryOperator longUnaryOperator = l -> l + 100;
        System.out.println(longUnaryOperator.applyAsLong(100));

        DoubleUnaryOperator doubleUnaryOperator = d -> d + 100;
        System.out.println(doubleUnaryOperator.applyAsDouble(200));
    }

    /**
     * T,T -> T
     *
     * IntBinaryOperator        int,int -> int
     * LongBinaryOperator       Long,Long -> Long
     * DoubleBinaryOperator     Double,Double -> Double
     */
    @Test
    public void testBinaryOperator(){
        BinaryOperator<String> binaryOperator = (s1, s2) -> "BinaryOperator: " + s1 + s2;
        System.out.println(binaryOperator.apply("xia", "zhang"));

        IntBinaryOperator intBinaryOperator = (i1, i2) -> i1 + i2;
        System.out.println(intBinaryOperator.applyAsInt(10,20));

        LongBinaryOperator longBinaryOperator = (l1, l2) -> l1 + l2;
        System.out.println(longBinaryOperator.applyAsLong(20, 30));

        DoubleBinaryOperator doubleBinaryOperator = (d1, d2) -> d1 + d2;
        System.out.println(doubleBinaryOperator.applyAsDouble(15, 25));
    }

    /**
     * T,R -> boolean
     *
     */
    public void testBiPredicate(){

    }

    /**
     * T,U -> void
     *
     * ObjIntConsumer<T>        T,int -> void
     * ObjLongConsumer<T>       T,Long -> void
     * ObjDoubleConsumer<T>     T,Double -> void
     */
    public void testBiCustomer(){

    }

    /**
     * T,U -> R
     *
     * ToIntBiFunction<T,U>         T,U -> int
     * ToLongBiFunction<T,U>        T,U -> Long
     * ToDoubleBiFunction<T,U>      T,U -> Double
     */
    public void testBiFunction(){

    }
}
