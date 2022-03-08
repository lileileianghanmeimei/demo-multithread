package com.example.demomultithread.Java8;

import com.alibaba.fastjson.JSON;
import com.example.java8.Fruit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class funcPredicateTest {

    @Test
    public void testProductStream() {
       /**方法引用
        * Fruit fruit = shopGet(funcPredicateTest::fruitPredicate);
        System.out.println(JSON.toJSONString(fruit));
*/
        Fruit fruit2 = shopGet(p -> p.getColor().equals("red"));
        System.out.println(JSON.toJSONString(fruit2));
    }

    public static boolean fruitPredicate(funcPredicateTest productTest) {
        /**
         * do other
         */
       //return productTest.getPrice() <= 5;
        return true;
    }


    public Fruit shopGet(Predicate<Fruit> predicate) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("苹果",5, "red"));
        list.add(new Fruit("苹果",5, "green"));
        list.add(new Fruit("香蕉", 8, "yellow"));
        list.add(new Fruit("香蕉", 8, "green"));
        Fruit fruit = list.stream().filter(f -> predicate.test(f)).findFirst().get();
        return fruit;
    }

}
